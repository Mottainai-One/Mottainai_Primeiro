package org.mot.jdbc_Mottainai.model;

public class Store {
    //ATRIBUTOS
    private int storeCode;
    private String email;
    private String complement;
    private String department;
    private String telephone;
    private String status;
    private int number;
    private String street;
    private String city;
    private String neighborhood;
    private int zipCode;
    private String state;
    private String description;
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
    //GETTERS
    public int getStoreCode() {
        return storeCode;
    }

    public String getEmail() {
        return email;
    }

    public String getComplement() {
        return complement;
    }

    public String getDepartment() {
        return department;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getStatus() {
        return status;
    }

    public int getNumber() {
        return number;
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

    public int getZipCode() {
        return zipCode;
    }

    public String getState() {
        return state;
    }

    public String getDescription() {
        return description;
    }

    public Company getCompany() {
        return company;
    }
    //SETTERS
    public void setEmail(String email) {
        this.email = email;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
