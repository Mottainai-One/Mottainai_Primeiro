package org.mot.aleluia.model;

public class User {
    //ATRIBUTOS
    private int id;
    private String userName;
    private String email;
    private String password;
    private String registrationDate;
    private String lastAcces;
    private String status;
    private String position;
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
    //GETTERS
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getLastAcces() {
        return lastAcces;
    }

    public String getStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public Employee getEmployee() {
        return employee;
    }
    //SETTERS
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public void setLastAcces(String lastAcces) {
        this.lastAcces = lastAcces;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
