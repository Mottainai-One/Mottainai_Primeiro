package com.mottainai.crudinicial.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "Store")

@Getter
@Setter
public class Store {
    //ATRIBUTOS

    @Id
    @Column(name = "Store")
    private int storeCode;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "Complement", nullable = false)
    private String complement;
    @Column(name = "Department", nullable = false)
    private String department;
    @Column(name = "Telephone", nullable = false)
    private String telephone;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "Number", nullable = false)
    private int number;
    @Column(name = "Street", nullable = false)
    private String street;
    @Column(name = "City", nullable = false)
    private String city;
    @Column(name = "Neighborhood", nullable = false)
    private String neighborhood;
    @Column(name = "ZipCode", nullable = false)
    private int zipCode;
    @Column(name = "State", nullable = false)
    private String state;
    @Column(name = "Description", nullable = false)
    private String description;
    @Column(name = "fkCompanyCNPJ", nullable = false)
    private Company company;

    //CONSTRUTOR
    public Store(String email, String telephone, int number, int zipCode, Company company) {
        this.email = email;
        this.telephone = telephone;
        this.number = number;
        this.zipCode = zipCode;
        this.company = company;
    }
    //SOBRECARGA
    public Store(int storeCode, String email, String complement, String department, String telephone, String status, int number, String street, String city, String neighborhood, int zipCode, String state, String description, Company company) {
        this.storeCode = storeCode;
        this.email = email;
        this.complement = complement;
        this.department = department;
        this.telephone = telephone;
        this.status = status;
        this.number = number;
        this.street = street;
        this.city = city;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.state = state;
        this.description = description;
        this.company = company;
    }
}
