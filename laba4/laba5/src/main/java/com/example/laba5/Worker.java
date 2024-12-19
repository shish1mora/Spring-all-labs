package com.example.laba5;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;




@Entity
@Table(name = "workers")
@Data
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Поле \"Фамилия\" не может быть пустым")
    @Size(min = 2, max = 30, message = "Допустимая длина фамилии от 2ух до 30ти символов")
    String surname;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Поле \"Имя\" не может быть пустым")
    @Size(min = 2, max = 30, message = "Допустимая длина имени от 2ух до 30ти символов")
    String name;

    @Column(name = "patronym", nullable = true)
    String patronym;

    @Column(name = "home_address", nullable = false)
    @NotBlank(message = "Поле \"Домашний адрес\" не может быть пустым")
    String homeAddress;

    @Column(name = "nationality", nullable = false)
    @NotBlank(message = "Поле \"Национальность\" не может быть пустым")
    String nationality;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth", nullable = false)
    LocalDate dateOfBirth;

    @Column(name = "department_no", nullable = false)
    Integer departmentNo;

    @Column(name = "tab_number", nullable = false)
    Integer tabNumber;

    @Column(name = "education", nullable = false)
    @NotBlank(message = "Поле \"Образование\" не может быть пустым")
    String education;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "employment_date", nullable = false)
    LocalDate employmentDate;

    @ManyToOne
    @JoinColumn(name = "factory_id")
    Factory factory;

    public Worker(Long id, String surname, String name, String patronym, String homeAddress, String nationality, LocalDate dateOfBirth, Integer departmentNo, Integer tabNumber, String education, LocalDate employmentDate) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronym = patronym;
        this.homeAddress = homeAddress;
        this.nationality = nationality;
        this.dateOfBirth = dateOfBirth;
        this.departmentNo = departmentNo;
        this.tabNumber = tabNumber;
        this.education = education;
        this.employmentDate = employmentDate;
    }
}