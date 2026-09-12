package org.mot.jdbc_Mottainai.model;

import java.time.LocalDate;

public class Employee {
    //ATRIBUTOS
    private String cpf;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private Store store;
    //CONSTRUTOR
    public Employee(String cpf, String name, String surname, Store store) {
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.store = store;
    }
    //SOBRECARGA
    public Employee(String cpf, String name, String surname, LocalDate birthDate, LocalDate employmentDate, Store store) {
        this.cpf = cpf;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate; // está date no banco
        this.employmentDate = employmentDate; // no banco está date
        this.store = store;
    }
    //GETTERS
    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public Store getStore() {
        return store;
    }
    //SETTERS
    public void setStore(Store store) {
        this.store = store;
    }

    //toString
    public String toString(){
        return "------------- EMPLYOEE ------------"+"\n"+
                "CPF: "+ this.cpf+"\n"+
                "Name: "+ this.name+"\n"+
                "Surname: "+ this.surname+"\n"+
                "Birth Date: "+ this.birthDate+"\n"+
                "Employment Date: "+ this.employmentDate+"\n"+
                "Store: "+ this.store+"\n"+
                "-----------------------------------";
    }
}
