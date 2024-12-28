package com.example.laba5;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FactoryMapper implements RowMapper<Factory> {
    //private final WorkerRepository workerRepository;

    //public FactoryMapper(WorkerRepository workerRepository) {this.workerRepository = workerRepository;}

    @Override
    public Factory mapRow(ResultSet rs, int rowNum) throws SQLException {
        Factory factory = new Factory();
        factory.setId(rs.getLong("id"));
        factory.setName(rs.getString("name"));

        return factory;
    }
}


