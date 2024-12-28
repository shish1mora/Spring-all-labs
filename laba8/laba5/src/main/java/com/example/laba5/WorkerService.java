//package com.example.laba5;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.example.laba5.Worker;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WorkerService {
//
//    @Autowired
//    private WorkerRepository workerRepository;
//
//    @Autowired
//    private FactoryRepository factoryRepository;
//
//    @Autowired
//    public void setWorkerRepository(WorkerRepository workerRepository) {
//        this.workerRepository = workerRepository;
//    }
//
//    public List<Worker> getAllWorkers() {
//        return (List<Worker>) workerRepository.findAll();
//    }
//
//    public List<Worker> getAllWorkersByDepartment(Integer departmentNo) {
//        return (List<Worker>) workerRepository.findByDepartmentNo(departmentNo);
//    }
//
//    public List<Worker> getAllWorkersByFactory(Factory factory) {
//        return (List<Worker>) workerRepository.findByFactory(factory);
//    }
//    public Worker getWorkerById(Long id) {
//        Optional<Worker> worker = workerRepository.findById(id);
//        if (worker.isEmpty()) {
//            throw new EntityNotFoundException("Работник не найден");
//        }
//        return worker.get();
//    }
//
//    public void deleteWorkerById(Long id) {
//        if (workerRepository.existsById(id)) {
//            workerRepository.deleteById(id);
//        }    }
//
//    public Worker addEditWorker(Worker worker) {
//        Factory factory = new Factory();
//        factory.setName(worker.getFactory().getName());
//        factory = factoryRepository.save(factory);
//        worker.setFactory(factory);
//        return workerRepository.save(worker);
//    }
//}