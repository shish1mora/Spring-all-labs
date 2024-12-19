package com.example.laba5;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "factories")
@Data
@NoArgsConstructor
@Getter
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @NotBlank(message = "Поле \"Название\" не может быть пустым")
    @Size(min = 5, message = "Короткое название завода")
    @Column(name = "name", nullable = false)
    String name;

    @OneToMany(mappedBy = "factory", cascade = CascadeType.ALL)
    @JsonBackReference
    List<Worker> workers;
}
