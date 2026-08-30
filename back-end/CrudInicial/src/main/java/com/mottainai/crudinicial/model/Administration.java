package com.mottainai.crudinicial.model;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Administration")

@Getter
@Setter
public class Administration {

    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Email", nullable = false)
    private String email;
    @Column(name = "Password", nullable = false)
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

    public Administration() {

    }
}
