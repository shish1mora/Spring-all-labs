package com.example.laba5;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.laba5.Factory;

import java.util.List;
import java.util.Optional;

@Service
public class FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    public void setFactoryRepository(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    public List<Factory> getAllFactories() {
        return (List<Factory>) factoryRepository.findAll();
    }

    public Factory getFactoryById(Long id) {
        Optional<Factory> factory = factoryRepository.findById(id);
        if(factory.isEmpty()) {
            throw new EntityNotFoundException("Завод не найден");
        }
        return factory.get();
    }

    public Factory getFactoryByName(String name) {
        return factoryRepository.findByName(name);
    }

    public void deleteFactoryById(Long id) {
        if (factoryRepository.existsById(id)) {
            factoryRepository.deleteById(id);
        }
    }

    public Factory addEditFactory(Factory factory) {
        return factoryRepository.save(factory);
    }
}