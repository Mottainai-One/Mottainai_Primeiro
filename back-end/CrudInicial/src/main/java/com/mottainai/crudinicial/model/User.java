package com.mottainai.crudinicial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.AccessLevel;

@Getter
@Setter

@Entity
@Table(name = "UserAccount")
public class User {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    @Column(name = "Username", nullable = false)
    private String userName;
    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
    private String password;
    @Column(name = "RegistrationDate", nullable = false)
    private String registrationDate;
    @Column(name = "LastAccess", nullable = false)
    private String lastAcces;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "Position", nullable = false)
    private String position;
//    @Column(name = "EmployeeCPF", nullable = false)
    @ManyToOne
    @JoinColumn(name = "employee_cpf")
    private Employee employee;
    //CONSTRUTOR
    public User(String userName, String email, String password, Employee employee, String position) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.employee = employee;
        this.position = position;
    }
    //SOBRECARGA
    public User(int id, String userName, String email, String password, String registrationDate, String lastAcces, String status, String position, Employee employee) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.lastAcces = lastAcces;
        this.status = status;
        this.position = position;
        this.employee = employee;
    }

    public User() {}
}
