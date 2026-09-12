package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    //CONSTRUTOR
    public CompanyDAO() {
    }

    //METODO DE LISTAGEM DOS REGISTROS
    public List<Company> list(){
        List<Company> companies = new ArrayList<>();

        try {
            String sql = "SELECT * FROM company"; //comando sql
            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão com o banco
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando sql
            ResultSet resultSet = pstm.executeQuery();//recenbendo os registros da query

            while(resultSet.next()){ //enquanto ainda tiver resultado...
                String cnpj = resultSet.getString("cnpj");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String name = resultSet.getString("name");
                String complement = resultSet.getString("complement");
                String email = resultSet.getString("email");
                LocalDate registrationDate= resultSet.getDate("registrationdate").toLocalDate();
                String state = resultSet.getString("state");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String neighborhood = resultSet.getString("neighborhood");
                String zipCode = resultSet.getString("zipcode");
                String number = resultSet.getString("number");
                String description = resultSet.getString("description");

                //crio um objeto com as variáveis e adiciono dentro do List
                companies.add(new Company(cnpj, name, complement, email, registrationDate, state, street, city, neighborhood, zipCode, number, description ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return companies;
    }

    //METODO DE INSERÇÃO NO BANCO
    public boolean insert(Company company){
        try {
            String sql = "INSERT INTO company VALUES (?,?,?,?,?,?,?,?,?,?,?,?)"; //comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando comando sql

            pstm.setString(1, company.getCnpj());//a cada ocorrência substituo "?" pelas informações do objeto
            pstm.setString(2, company.getName());
            pstm.setString(3, company.getComplement());
            pstm.setString(4, company.getEmail());
            pstm.setObject(5, company.getRegistrationDate());
            pstm.setString(6, company.getState());
            pstm.setString(7, company.getStreet());
            pstm.setString(8, company.getCity());
            pstm.setString(9, company.getNeighborhood());
            pstm.setString(10, company.getZipCode());
            pstm.setString(11, company.getNumber());
            pstm.setString(12, company.getDescription());
            pstm.execute();//executando o comando sql no banco

        } catch (SQLException e) {//exceção
            throw new RuntimeException(e);
        }
        return true;
    }

    //METODO DE ATUALIZAÇÃO NO BANCO
    public boolean update(Company company){
        try {
            String sql = "UPDATE company SET name = ?, complement = ?, email = ?, registrationdate = ?, state = ?, street = ?, city = ?, neighborhood = ?, zipcode = ?, number = ?, description = ? WHERE cnpj = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão com o banco
            PreparedStatement pstm = connection.prepareStatement(sql);// preparando o comando

            pstm.setString(1, company.getName());//substituindo cada ocorrência por uma informação do objeto
            pstm.setString(2, company.getComplement());
            pstm.setString(3, company.getEmail());
            pstm.setObject(4, company.getRegistrationDate());
            pstm.setString(5, company.getState());
            pstm.setString(6, company.getStreet());
            pstm.setString(7, company.getCity());
            pstm.setString(8, company.getNeighborhood());
            pstm.setString(9, company.getZipCode());
            pstm.setString(10, company.getNumber());
            pstm.setString(11, company.getDescription());
            pstm.setString(12, company.getCnpj());
            pstm.execute();//executando o comando sql no banco

            return true;

        } catch (SQLException e) {//exceção
            throw new RuntimeException(e);
        }
    }

    //METODO DE APAGAR OS REGISTROS NO BANCO
    public boolean delete(String cnpj){
        try {
            String sql = "DELETE FROM company WHERE cnpj = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão com o banco
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando sql

            pstm.setString(1, cnpj);//substituindo a ocorrência do "?" pelo cnpj passado como parâmetro
            pstm.execute();//executando o comando
            return true;

        } catch (SQLException e) {//exceção
            throw new RuntimeException(e);
        }
    }

    //METODO QUE RETORNA O OBJETO COMPANY
    public Company find(String cnpj){
        Company company = null;
        try {
            String sql = "SELECT * FROM company WHERE cnpj = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando sql

            pstm.setString(1, cnpj);//substituindo a ocorrência pelo parâmetro

            ResultSet resultSet = pstm.executeQuery();//recebendo o comando sql

            if (resultSet.next()){//se ainda tiver resultado
                String cnpj1 = resultSet.getString("cnpj");
                String name = resultSet.getString("name");
                String complement = resultSet.getString("complement");
                String email = resultSet.getString("email");
                LocalDate registrationDate = resultSet.getDate("registrationdate").toLocalDate();
                String state = resultSet.getString("state");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String neighborhood = resultSet.getString("neighborhood");
                String zipCode = resultSet.getString("zipcode");
                String number = resultSet.getString("number");
                String description = resultSet.getString("description");

                 company = new Company(cnpj1, name, complement, email, registrationDate, state, street, city, neighborhood, zipCode, number, description);
            }

        } catch (SQLException e) {//exceção
            throw new RuntimeException(e);
        }
        return company;
    }
}
