package com.example.laba5;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.example.laba5.Worker;
import java.util.List;
import java.util.Optional;


@Repository
public interface WorkerRepository extends CrudRepository<Worker, Long> {


    List<Worker>  findByDepartmentNo(Integer departmentNo);
    List<Worker>  findByFactory(Factory factory);


}
