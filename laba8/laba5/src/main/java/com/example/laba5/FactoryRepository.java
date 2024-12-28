package com.example.laba5;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import  com.example.laba5.Factory;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FactoryRepository {
    private final JdbcTemplate jdbcTemplate;

    public FactoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Factory> findAll() {
        return jdbcTemplate.query("SELECT * FROM factories", new FactoryMapper());
    }

    public Factory findById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM factories WHERE id = ?", new Object[]{id}, new FactoryMapper());
    }

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM factories WHERE id = ?", id);
    }
    public Factory add(Factory factory) {
        jdbcTemplate.update("INSERT INTO factories (name) VALUES (?)",
                factory.getName()
        );
        return factory;
    }


    public Factory findByName(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM factories WHERE name = ?", new Object[]{name}, new FactoryMapper());
    }

    public void update(Long id, Factory existingFactory) {
        jdbcTemplate.update("UPDATE factories SET name = ? WHERE id = ?",

                existingFactory.getName(), existingFactory.getId());

    }
}



