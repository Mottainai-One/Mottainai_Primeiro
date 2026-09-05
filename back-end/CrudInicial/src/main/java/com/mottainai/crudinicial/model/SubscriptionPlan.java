package com.mottainai.crudinicial.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriptionPlan {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "Id")
    private int id;
    @Column(name = "Description", nullable = false)
    private String description;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "CreationDate", nullable = false)
    private String registrationDate;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "StoreLimit", nullable = false)
    private int storeLimit;
//    @Column(name = "CompanyCNPJ", nullable = false)
    private Company company;
    //CONSTRUTOR
    public SubscriptionPlan(String registrationDate, double price, int storeLimit, Company company) {
        this.registrationDate = registrationDate;
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }
    //SOBRECARGA
    public SubscriptionPlan(int id, String description, String status, String registrationDate, double price, int storeLimit, Company company) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.registrationDate = registrationDate;
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }

}
