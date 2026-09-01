package org.mot.aleluia.model;

public class Administration {
    //ATRIBUTOS
    private int id;
    private String email;
    private String password;
    //CONSTRUTOR
    public Administration(String email, String password) {
        this.email = email;
        this.password = password;
    }
    //SOBRECARGA
    public Administration(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    //SETTERS
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
