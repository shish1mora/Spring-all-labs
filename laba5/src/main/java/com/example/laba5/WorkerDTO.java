package com.example.laba5;

import lombok.Data;

@Data
public class WorkerDTO {
    private Long id;
    private String surname;
    private String name;
    private String patronym;
    private String homeAddress;
    private String nationality;
    private String dateOfBirth;
    private Integer departmentNo;
    private Integer tabNumber;
    private String education;
    private String employmentDate;
    private FactoryDTO factory;
}
