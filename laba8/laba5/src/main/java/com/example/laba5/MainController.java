//package com.example.laba5;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import com.example.laba5.FactoryDTO;
//import com.example.laba5.WorkerDTO;
//import com.example.laba5.Factory;
//import com.example.laba5.Worker;
//
//
//import java.util.List;
//
//@Controller
//public class MainController {
//
//    private final WorkerRepository workerRepository;
//    private final FactoryRepository factoryRepository;
//
//    @Autowired
//    public MainController(WorkerRepository workerRepository, FactoryRepository factoryRepository) {
//        this.workerRepository = workerRepository;
//        this.factoryRepository = factoryRepository;
//    }
//
//    @GetMapping("/workers")
//    public String WorkersPage(Model model) {
//        List<Worker> allWorkers = workerRepository.findAll();
//        model.addAttribute("workers", allWorkers);
//        model.addAttribute("factory", new Factory());
//        return "workers";
//    }
//
//    @GetMapping("/factorys")
//    public String FactorysPage(Model model) {
//        List<Factory> allFactories = factoryRepository.findAll();
//        model.addAttribute("factorys", allFactories);
//        return "factorys";
//    }
//
//    @GetMapping("/workers/details/{id}")
//    public String workerDetailsPage(Model model, @PathVariable("id") Long id) {
//        Worker selectedWorker = workerRepository.findById(id).orElse(null);
//        model.addAttribute("selectedWorker", selectedWorker);
//        return "workerdetails";
//    }
//
//    @GetMapping("/factorys/details/{id}")
//    public String factoryDetailsPage(Model model, @PathVariable("id") Long id) {
//        Factory selectedFactory = factoryRepository.findById(id).orElse(null);
//        model.addAttribute("selectedFactory", selectedFactory);
//        return "factorydetails";
//    }
//
//    @GetMapping("/workers/delete/{id}")
//    public String deleteWorkerById(@PathVariable("id") Long id) {
//        workerRepository.deleteById(id);
//        return "redirect:/workers";
//    }
//
//    @GetMapping("/factorys/delete/{id}")
//    public String deleteFactoryById(@PathVariable("id") Long id) {
//        factoryRepository.deleteById(id);
//        return "redirect:/factorys";
//    }
//
//    @GetMapping("/workers/add")
//    public String addWorker(Model model) {
//        model.addAttribute("worker", new Worker());
//        return "addeditworker";
//    }
//
//    @GetMapping("/factorys/add")
//    public String addFactory(Model model) {
//        model.addAttribute("factory", new Factory());
//        return "addeditfactory";
//    }
//
//    @PostMapping("/workers/add")
//    public String mainWorkerForm(@ModelAttribute("worker") @Valid Worker worker, BindingResult result) {
//        if (result.hasErrors()) {
//            return "addeditworker";
//        }
//        workerRepository.save(worker); // Сохранение работника через репозиторий
//        return "redirect:/workers";
//    }
//
//    @PostMapping("/factorys/add")
//    public String mainFactoryForm(@ModelAttribute("factory") @Valid Factory factory, BindingResult result) {
//        if (result.hasErrors()) {
//            return "addeditfactory";
//        }
//        factoryRepository.save(factory); // Сохранение фабрики через репозиторий
//        return "redirect:/factorys";
//    }
//
//    @GetMapping("/workers/update/{id}")
//    public String editWorker(Model model, @PathVariable("id") Long id) {
//        Worker worker = workerRepository.findById(id).orElse(null);
//        model.addAttribute("worker", worker);
//        return "addeditworker";
//    }
//
//    @GetMapping("/factorys/update/{id}")
//    public String editFactory(Model model, @PathVariable("id") Long id) {
//        Factory factory = factoryRepository.findById(id).orElse(null);
//        model.addAttribute("factory", factory);
//        return "addeditfactory";
//    }
//
//    @PostMapping("/findworkersbyfactory")
//    public String getWorkers(@ModelAttribute Factory factory, Model model) {
//        if (factory.getName().isEmpty()) {
//            return "redirect:/kazarma";
//        }
//        List<Worker> workers = workerRepository.findByFactoryId(factory.getId()); // Метод для получения работников по фабрике
//        model.addAttribute("workers", workers);
//        model.addAttribute("factory", new Factory());
//        return "workers";
//    }
//}
//
//
