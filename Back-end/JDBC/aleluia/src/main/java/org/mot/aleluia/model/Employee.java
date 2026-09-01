package org.mot.aleluia.model;

public class Employee {
    //ATRIBUTOS
    private int cpf;
    private String name;
    private String surname;
    private String birthDate;
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
    public Employee(int cpf, String name, String surname, String birthDate, String employmentDate, Store store) {
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.store = store;
    }
    //GETTERS
    public int getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public Store getStore() {
        return store;
    }
    //SETTERS
    public void setStore(Store store) {
        this.store = store;
    }
}
