package com.mottainai.crudinicial.model;

import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Employee")

@Getter
public class Employee {

    @Id
    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private int cpf;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Surname", nullable = false)
    private String surname;

    @Column(name = "BirthDate", nullable = false)
    private String birthDate;

    @Column(name = "EmploymentDate", nullable = false)
    private String employmentDate;

    private Store store;
    //CONSTRUTOR

    public Employee(int cpf, String name, String surname, Store store) {
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.store = store;
    }
    //SOBRECARGA
    public Employee() {}
    public Employee(int cpf, String name, String surname, String birthDate, String employmentDate, Store store) {
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.store = store;
    }
}
