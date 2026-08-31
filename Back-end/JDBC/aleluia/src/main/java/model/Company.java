package model;

public class Company {
    //ATRIBUTOS
    private int cnpj;
    private String name;
    private String complement;
    private String email;
    private String registrationDate;
    private String state;
    private String street;
    private String city;
    private String neighborhood;
    private int zipCode;
    private int number;
    private String description;
    //CONSTRUTOR
    public Company(int cnpj, String name, String email, String registrationDate, int zipCode, int number) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.zipCode = zipCode;
        this.number = number;
    }
    //SOBRECARGA
    public Company(int cnpj, String name, String complement, String email, String registrationDate, String state, String street, String city, String neighborhood, int zipCode, int number, String description) {
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
    public int getCnpj() {
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

    public String getRegistrationDate() {
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

    public int getZipCode() {
        return zipCode;
    }

    public int getNumber() {
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

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
