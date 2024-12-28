package com.example.laba5;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RequestMapping("/api")
@RestController
public class WorkerController {

    private final WorkerRepository workerRepository;
    private final FactoryRepository factoryRepository;

    @Autowired
    public WorkerController(WorkerRepository workerRepository, FactoryRepository factoryRepository) {
        this.workerRepository = workerRepository;
        this.factoryRepository = factoryRepository;
    }

    @GetMapping("/workers")
    public List<Worker> listOfWorkers() {
        return workerRepository.findAll();
    }

    @GetMapping("/factories")
    public List<Factory> listOfFactories() {
        return factoryRepository.findAll(); // Предполагается, что у вас есть соответствующий метод в FactoryRepository
    }

    @GetMapping("/worker/{id}")
    public Worker getWorker(@PathVariable("id") Long id) {
        return workerRepository.findById(id);
    }

    @GetMapping("/factory/{id}")
    public Factory getFactory(@PathVariable("id") Long id) {
        return factoryRepository.findById(id); // Предполагается, что у вас есть соответствующий метод в FactoryRepository
    }

    @PostMapping("/worker/add")
    public Worker newWorker(@RequestBody WorkerDTO workerDTO) {
        Factory factory = factoryRepository.findByName(workerDTO.getFactory().getTitle());
        Worker worker = new Worker();
        worker.setSurname(workerDTO.getSurname());
        worker.setName(workerDTO.getName());
        worker.setPatronym(workerDTO.getPatronym());
        worker.setHomeAddress(workerDTO.getHomeAddress());
        worker.setNationality(workerDTO.getNationality());
        worker.setDateOfBirth(LocalDate.parse(workerDTO.getDateOfBirth()));
        worker.setDepartmentNo(workerDTO.getDepartmentNo());
        worker.setTabNumber(workerDTO.getTabNumber());
        worker.setEducation(workerDTO.getEducation());
        worker.setEmploymentDate(LocalDate.parse(workerDTO.getEmploymentDate()));
        worker.setFactory(factory);
        return workerRepository.add(worker); // Используем метод add для сохранения работника
    }

    @PostMapping("/factory/add")
    public Factory newFactory(@RequestBody FactoryDTO factoryDTO) {
        Factory factory = new Factory();
        factory.setName(factoryDTO.getTitle());
        return factoryRepository.add(factory); // Предполагается, что у вас есть соответствующий метод в FactoryRepository
    }

    @PutMapping("/worker/{id}")
    public Worker updateWorker(@RequestBody WorkerDTO workerDTO, @PathVariable("id") Long id) {
        Worker existingWorker = workerRepository.findById(id);
        if (existingWorker == null) {
            return null; // Или выбросьте исключение, если работник не найден
        }
        Factory factory = factoryRepository.findByName(workerDTO.getFactory().getTitle());
        existingWorker.setSurname(workerDTO.getSurname());
        existingWorker.setName(workerDTO.getName());
        existingWorker.setPatronym(workerDTO.getPatronym());
        existingWorker.setHomeAddress(workerDTO.getHomeAddress());
        existingWorker.setNationality(workerDTO.getNationality());
        existingWorker.setDateOfBirth(LocalDate.parse(workerDTO.getDateOfBirth()));
        existingWorker.setDepartmentNo(workerDTO.getDepartmentNo());
        existingWorker.setTabNumber(workerDTO.getTabNumber());
        existingWorker.setEducation(workerDTO.getEducation());
        existingWorker.setEmploymentDate(LocalDate.parse(workerDTO.getEmploymentDate()));
        existingWorker.setFactory(factory);
        workerRepository.update(id, existingWorker); // Обновляем работника через метод update
        return existingWorker; // Возвращаем обновленного работника
    }

    @PutMapping("/factory/{id}")
    public Factory updateFactory(@RequestBody FactoryDTO factoryDTO, @PathVariable("id") Long id) {
        Factory existingFactory = factoryRepository.findById(id);
        if (existingFactory == null) {
            return null; // Или выбросьте исключение, если фабрика не найдена
        }
        existingFactory.setName(factoryDTO.getTitle());
        factoryRepository.update(id, existingFactory); // Предполагается, что у вас есть соответствующий метод в FactoryRepository
        return existingFactory; // Возвращаем обновленную фабрику
    }

    @DeleteMapping("/worker/{id}")
    public void deleteWorker(@PathVariable("id") Long id) {
        workerRepository.deleteById(id);
    }

    @DeleteMapping("/factory/{id}")
    public void deleteFactory(@PathVariable("id") Long id) {
        factoryRepository.deleteById(id);
    }
}



