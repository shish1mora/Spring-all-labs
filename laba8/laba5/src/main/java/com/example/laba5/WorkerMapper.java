package com.example.laba5;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerMapper implements RowMapper<Worker> {
    private final FactoryRepository factoryRepository;

    public WorkerMapper(FactoryRepository factoryRepository) {
        this.factoryRepository = factoryRepository;
    }

    @Override
    public Worker mapRow(ResultSet rs, int rowNum) throws SQLException {
        Worker worker = new Worker();
        worker.setId(rs.getLong("id"));
        worker.setSurname(rs.getString("surname"));
        worker.setName(rs.getString("name"));
        worker.setPatronym(rs.getString("patronym"));
        worker.setHomeAddress(rs.getString("home_address"));
        worker.setNationality(rs.getString("nationality"));
        worker.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());
        worker.setDepartmentNo(rs.getInt("department_no"));
        worker.setTabNumber(rs.getInt("tab_number"));
        worker.setEducation(rs.getString("education"));
        worker.setEmploymentDate(rs.getDate("employment_date").toLocalDate());


        return worker;
    }
}

