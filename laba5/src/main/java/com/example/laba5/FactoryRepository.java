package com.example.laba5;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.example.laba5.Factory;


@Repository
public interface FactoryRepository extends CrudRepository<Factory, Long> {


    Factory findByName(String name);
}
