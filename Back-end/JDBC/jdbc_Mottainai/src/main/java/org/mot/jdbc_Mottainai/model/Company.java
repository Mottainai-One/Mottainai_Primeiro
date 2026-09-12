package org.mot.jdbc_Mottainai.model;

import java.time.LocalDate;

public class Company {
    //ATRIBUTOS
    private String cnpj;
    private String name;
    private String complement;
    private String email;
    private LocalDate registrationDate;//é date no banco
    private String state;
    private String street;
    private String city;
    private String neighborhood;
    private String zipCode;
    private String number;
    private String description;
    //CONSTRUTOR
    public Company(String cnpj, String name, String email, LocalDate registrationDate, String zipCode, String number) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.zipCode = zipCode;
        this.number = number;
    }
    //SOBRECARGA
    public Company(String cnpj, String name, String complement, String email, LocalDate registrationDate, String state, String street, String city, String neighborhood, String zipCode, String number, String description) {
        this.cnpj = cnpj;
        this.name = name;
        this.complement = complement;
        this.email = email;
        this.registrationDate = registrationDate;
        this.state = state;
        this.street = street;
        this.city = city;
        this.neighborhood = neighborhood;
        this.zipCode = zipCode;
        this.number = number;
        this.description = description;
    }
    //GETTERS
    public String getCnpj() {
        return cnpj;
    }

    public String getName() {
        return name;
    }

    public String getComplement() {
        return complement;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //toString
    public String toString(){
        return "----------- COMPANY ----------"+"\n"+
                "CNPJ: "+ this.cnpj+"\n"+
                "Name: "+ this.name+"\n"+
                "Complement: "+ this.complement+"\n" +
                "Email: "+ this.email+"\n"+
                "Registration Date: "+ this.registrationDate+"\n"+
                "State: "+ this.state+"\n"+
                "Street: "+ this.street+"\n"+
                "City: "+ this.city+ "\n"+
                "Neighborhood: "+ this.neighborhood+"\n"+
                "Zip Code: "+ this.zipCode+"\n" +
                "Number: "+ this.number+"\n"+
                "Description: "+ this.description+"\n"+
                "-------------------------------";
    }
}
