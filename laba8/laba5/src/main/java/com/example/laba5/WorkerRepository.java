package com.example.laba5;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.example.laba5.Worker;
import java.util.List;
import java.util.Optional;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class WorkerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final FactoryRepository factoryRepository;

    public WorkerRepository(JdbcTemplate jdbcTemplate, FactoryRepository factoryRepository) {
        this.jdbcTemplate = jdbcTemplate;
        this.factoryRepository = factoryRepository;
    }

    public List<Worker> findAll() {
        return jdbcTemplate.query("SELECT * FROM workers", new WorkerMapper(factoryRepository));
    }

    public Worker findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM workers WHERE id = ?", new Object[]{id}, new WorkerMapper(factoryRepository));
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM workers WHERE id = ?", id);
    }

    public void update(Long id, Worker worker) {
        jdbcTemplate.update("UPDATE workers SET surname = ?, name = ?, patronym = ?, home_address = ?, nationality = ?, " +
                        "date_of_birth = ?, department_no = ?, tab_number = ?, education = ?, employment_date = ?, factory_id = ? " +
                        "WHERE id = ?",
                worker.getSurname(),
                worker.getName(),
                worker.getPatronym(),
                worker.getHomeAddress(),
                worker.getNationality(),
                java.sql.Date.valueOf(worker.getDateOfBirth()), // Преобразуем LocalDate в java.sql.Date
                worker.getDepartmentNo(),
                worker.getTabNumber(),
                worker.getEducation(),
                java.sql.Date.valueOf(worker.getEmploymentDate()), // Преобразуем LocalDate в java.sql.Date
                worker.getFactory() != null ? worker.getFactory().getId() : null, // Получаем id фабрики
                id);
    }

    public Worker add(Worker worker) {
        Long factoryId = worker.getFactory() != null ? worker.getFactory().getId() : null;

        jdbcTemplate.update("INSERT INTO workers (surname, name, patronym, home_address, nationality, date_of_birth, " +
                        "department_no, tab_number, education, employment_date, factory_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                worker.getSurname(),
                worker.getName(),
                worker.getPatronym(),
                worker.getHomeAddress(),
                worker.getNationality(),
                java.sql.Date.valueOf(worker.getDateOfBirth()), // Преобразуем LocalDate в java.sql.Date
                worker.getDepartmentNo(),
                worker.getTabNumber(),
                worker.getEducation(),
                java.sql.Date.valueOf(worker.getEmploymentDate()), // Преобразуем LocalDate в java.sql.Date
                factoryId // Используем id фабрики
        );

        return worker;
    }
}

