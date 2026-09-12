package com.mottainai.crudinicial.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Company")

@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String complement;

    @Column(nullable = false, unique = true, length = 100)
    private String email;


    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;  // <-- MUDOU para LocalDateTime

    @Column(length = 2)
    private String state;

    @Column(length = 100)
    private String street;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String neighborhood;

    @Column(name = "zip_code")
    private Integer zipCode;  // <-- MUDOU de int para Integer

    @Column
    private Integer number;  // <-- MUDOU de int para Integer

    @Column(columnDefinition = "TEXT")
    private String description;


    //CONSTRUTOR
    public Company(){}
    public Company(String cnpj, String name, String email, LocalDateTime registrationDate) {
        this.cnpj = cnpj;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
    }
    //SOBRECARGA do construtor
    //Não é necessária


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) && Objects.equals(cnpj, company.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cnpj);
    }

    @Override
    public String toString() {
        return "Company {" +
                "id=" + id +
                ", cnpj'" + cnpj + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate + '}';
    }

}
