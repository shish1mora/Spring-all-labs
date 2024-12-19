//package com.example.laba5;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//import com.example.laba5.FactoryDTO;
//import com.example.laba5.WorkerDTO;
//import com.example.laba5.Factory;
//import com.example.laba5.Worker;
//import com.example.laba5.FactoryService;
//import com.example.laba5.WorkerService;
//
//
//@RequestMapping("/api")
//@RestController
//public class WorkerController {
//
//    private WorkerService workerService;
//    private FactoryService factoryService;
//
//    @Autowired
//    public void setWorkerService(WorkerService workerService) {
//        this.workerService = workerService;
//    }
//
//    @Autowired
//    public void setFactoryService(FactoryService factoryService) {
//        this.factoryService = factoryService;
//    }
//
//    @GetMapping("/workers")
//    public List<Worker> listOfWorkers() {
//        return (List<Worker>) workerService.getAllWorkers();
//    }
//
//    @GetMapping("/factories")
//    public List<Factory> listOfFactories() {
//        return (List<Factory>) factoryService.getAllFactories();
//    }
//
//    @GetMapping("/worker/{id}")
//    public Worker getWorker(@PathVariable("id") Long id) {
//        return workerService.getWorkerById(id);
//    }
//
//    @GetMapping("/factory/{id}")
//    public Factory getFactory(@PathVariable("id") Long id) {
//        return factoryService.getFactoryById(id);
//    }
//
//    @PostMapping("/worker/add")
//    public Worker newWorker(@RequestBody WorkerDTO workerDTO) {
//        Factory factory = factoryService.getFactoryByName(workerDTO.getFactory().getTitle());
//        Worker worker = new Worker();
//        worker.setSurname(workerDTO.getSurname());
//        worker.setName(workerDTO.getName());
//        worker.setPatronym(workerDTO.getPatronym());
//        worker.setHomeAddress(workerDTO.getHomeAddress());
//        worker.setNationality(workerDTO.getNationality());
//        worker.setDateOfBirth(LocalDate.parse(workerDTO.getDateOfBirth()));
//        worker.setDepartmentNo(workerDTO.getDepartmentNo());
//        worker.setTabNumber(workerDTO.getTabNumber());
//        worker.setEducation(workerDTO.getEducation());
//        worker.setEmploymentDate(LocalDate.parse(workerDTO.getEmploymentDate()));
//        worker.setFactory(factory);
//        return workerService.addEditWorker(worker);
//    }
//
//    @PostMapping("/factory/add")
//    public Factory newFactory(@RequestBody FactoryDTO factoryDTO) {
//        Factory factory = new Factory();
//        factory.setName(factoryDTO.getTitle());
//        return factoryService.addEditFactory(factory);
//    }
//
//    @PutMapping("/worker/{id}")
//    public Worker updateWorker(@RequestBody WorkerDTO workerDTO, @PathVariable("id") Long id) {
//        Worker existingWorker = workerService.getWorkerById(id);
//        Factory factory = factoryService.getFactoryByName(workerDTO.getFactory().getTitle());
//        Worker worker = new Worker();
//        worker.setId(existingWorker.getId());
//        worker.setSurname(workerDTO.getSurname());
//        worker.setName(workerDTO.getName());
//        worker.setPatronym(workerDTO.getPatronym());
//        worker.setHomeAddress(workerDTO.getHomeAddress());
//        worker.setNationality(workerDTO.getNationality());
//        worker.setDateOfBirth(LocalDate.parse(workerDTO.getDateOfBirth()));
//        worker.setDepartmentNo(workerDTO.getDepartmentNo());
//        worker.setTabNumber(workerDTO.getTabNumber());
//        worker.setEducation(workerDTO.getEducation());
//        worker.setEmploymentDate(LocalDate.parse(workerDTO.getEmploymentDate()));
//        worker.setFactory(factory);
//        return workerService.addEditWorker(worker);
//    }
//    @PutMapping("/factory/{id}")
//    public Factory updateFactory(@RequestBody FactoryDTO factoryDTO,
//                           @PathVariable("id") Long id){
//        Factory existFactory = factoryService.getFactoryById(id);
//        Factory factory = new Factory();
//        factory.setId(existFactory.getId());
//        factory.setName(factoryDTO.getTitle());
//
//        return factoryService.addEditFactory(factory);
//    }
//
//    @DeleteMapping("/worker/{id}")
//    public void deleteWorker(@PathVariable("id") Long id){
//        workerService.deleteWorkerById(id);
//    }
//
//    @DeleteMapping("/factory/{id}")
//    public void deleteFactory(@PathVariable("id") Long id){
//        factoryService.deleteFactoryById(id);
//    }
//}
