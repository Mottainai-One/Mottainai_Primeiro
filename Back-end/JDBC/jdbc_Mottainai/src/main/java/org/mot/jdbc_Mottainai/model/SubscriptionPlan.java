package org.mot.jdbc_Mottainai.model;

import java.time.LocalDate;

public class SubscriptionPlan {
    //ATRIBUTOS
    private int id;
    private String description;
    private String status;
    private LocalDate registrationDate;
    private double price;
    private int storeLimit;
    private Company company;
    //CONSTRUTOR
    public SubscriptionPlan(LocalDate registrationDate, double price, int storeLimit, Company company) {
        this.registrationDate = registrationDate;
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }
    //SOBRECARGA
    public SubscriptionPlan( int id, String description, String status, LocalDate registrationDate, double price, int storeLimit, Company company) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.registrationDate = registrationDate; // está como date e é criationDate
        this.price = price;
        this.storeLimit = storeLimit;
        this.company = company;
    }
    //GETTERS
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public double getPrice() {
        return price;
    }

    public int getStoreLimit() {
        return storeLimit;
    }

    public Company getCompany() {
        return company;
    }
    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStoreLimit(int storeLimit) {
        this.storeLimit = storeLimit;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //toString
    public String toString(){
        return "------------ SUBSCRIPTION PLAN ------------"+ "\n"+
                "ID: "+ this.id+ "\n"+
                "Description: "+ this.description+ "\n"+
                "Status: "+ this.status+"\n"+
                "Registration Date: "+ this.registrationDate+ "\n"+
                "Price: R$"+ this.price+"\n"+
                "Store Limit: "+ this.storeLimit+"\n"+
                "Company: "+ this.company+"\n"+
                "-------------------------------------------";
    }
}

