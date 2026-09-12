package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDAO {

    //CONSTRUTOR
    public StoreDAO() {
    }

    //MÉTODOS
    public boolean insert(Store store){
        try {
            String sql = "INSERT INTO store VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1, store.getStoreCode());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, store.getEmail());
            pstm.setString(3, store.getComplement());
            pstm.setString(4, store.getDepartment());
            pstm.setString(5, store.getTelephone());
            pstm.setString(6, store.getStatus());
            pstm.setString(7, store.getNumber());
            pstm.setString(8, store.getStreet());
            pstm.setString(9, store.getCity());
            pstm.setString(10, store.getNeighborhood());
            pstm.setString(11, store.getZipCode());
            pstm.setString(12, store.getState());
            pstm.setString(13, store.getDescription());
            pstm.setObject(14, store.getCompany().getCnpj());
            pstm.execute();//executando o comando sql

            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO DE SELEÇÃO DOS REGISTROS NO BANCO
    public List<Store> list(){
        List<Store> stores = new ArrayList<>();

        try {
            String sql = "SELECT * FROM store";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro
            ResultSet resultSet = pstm.executeQuery();//aramazenando o resultado da minha consulta ao ser executado

            while (resultSet.next()){//enquanto ainda tiver resultado
                int storeCode = resultSet.getInt("storecode");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String email = resultSet.getString("email");
                String complement = resultSet.getString("complement");
                String department = resultSet.getString("department");
                String telephone = resultSet.getString("telephone");
                String status = resultSet.getString("status");
                String number = resultSet.getString("number");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String neighborhood = resultSet.getString("neighborhood");
                String zipcode = resultSet.getString("zipcode");
                String state = resultSet.getString("state");
                String description = resultSet.getString("description");

                String cnpj = resultSet.getString("fkcompanycnpj"); //REVER ESSA LINHA

                Company company = new CompanyDAO().find(cnpj);//retorno um objeto específico
                stores.add(new Store(storeCode, email, complement, department, telephone, status, number, street, city, neighborhood, zipcode, state, description, company));//insatancio e passo o objeto para o array
            }
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stores;
    }

    //METODO DE ATUALIZAÇÃO DOS REGISTROS NO BANCO
    public boolean update(Store store){

        try {
            String sql = "UPDATE store SET email = ?, complement = ?, department = ?, telephone = ?, status = ?, number = ?, street = ?, city = ?, neighborhood = ?, zipcode = ?, state = ?, description = ?, fkcompanycnpj = ? WHERE storecode = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, store.getEmail());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, store.getComplement());
            pstm.setString(3, store.getDepartment());
            pstm.setString(4, store.getTelephone());
            pstm.setString(5, store.getStatus());
            pstm.setString(6, store.getNumber());
            pstm.setString(7, store.getStreet());
            pstm.setString(8, store.getCity());
            pstm.setString(9, store.getNeighborhood());
            pstm.setString(10, store.getZipCode());
            pstm.setString(11, store.getState());
            pstm.setString(12, store.getDescription());
            pstm.setString(13, store.getCompany().getCnpj());
            pstm.setInt(14, store.getStoreCode());
            pstm.execute();//executando o comando sql
            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO DE DELEÇÃO DOS REGISTROS NO BANCO
    public boolean delete(int storeCode){
        try {
            String sql = "DELETE FROM store WHERE storecode = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//comando sql
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1, storeCode);//passo o parâmetro para a identificação do registro no comando sql
            pstm.execute();//executando meu comando sql
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO QUE RETORNA UM OBJETO ESPECÍFICO
    public Store find(int storeCode){
        Store store = null;
        Company company = null;

        try {
            String sql = "SELECT * FROM store WHERE storecode = ?";//seleciono um registro específico

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1, storeCode);//passo o parâmetro para a identificação do registro no comando sql
            ResultSet resultSet = pstm.executeQuery();//aramazenando o resultado da minha consulta ao ser executado//aramazenando o resultado da minha consulta ao ser executado

            if (resultSet.next()){
                int storeCode1 = resultSet.getInt("storecode");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String email = resultSet.getString("email");
                String complement = resultSet.getString("complement");
                String department = resultSet.getString("department");
                String telephone = resultSet.getString("telephone");
                String status = resultSet.getString("status");
                String number = resultSet.getString("number");
                String street = resultSet.getString("street");
                String city = resultSet.getString("city");
                String neighborhood = resultSet.getString("neighborhood");
                String zipcode = resultSet.getString("zipcode");
                String state = resultSet.getString("state");
                String description = resultSet.getString("description");

                String cnpj = resultSet.getString("fkcompanycnpj");

                company = new CompanyDAO().find(cnpj);
                store = new Store(storeCode1, email, complement, department, telephone, status, number, street, city, neighborhood, zipcode, state, description, company);
            }
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return store;
    }
}
