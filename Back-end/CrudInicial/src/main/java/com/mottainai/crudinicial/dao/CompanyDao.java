package com.mottainai.crudinicial.dao;

import com.mottainai.crudinicial.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // Anotação do Spring
public interface CompanyDao extends JpaRepository<Company, Long> {
    // JpaRepository já tem os métodos CRUD prontos:
    // save(), findById(), findAll(), deleteById(), etc.


}