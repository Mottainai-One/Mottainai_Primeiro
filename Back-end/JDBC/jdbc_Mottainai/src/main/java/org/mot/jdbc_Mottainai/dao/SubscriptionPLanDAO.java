package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Company;
import org.mot.jdbc_Mottainai.model.SubscriptionPlan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionPLanDAO {

    //CONSTRUTOR
    public SubscriptionPLanDAO() {
    }

    //METODO DE INSERÇÃO DOS REGISTROS NO BANCO
    public boolean insert(SubscriptionPlan subscriptionPlan){
        try {
            String sql = "INSERT INTO subscriptionplan VALUES (?,?,?,?,?,?,?)";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1, subscriptionPlan.getId());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, subscriptionPlan.getDescription());
            pstm.setString(3, subscriptionPlan.getStatus());
            pstm.setObject(4, subscriptionPlan.getRegistrationDate());
            pstm.setDouble(5, subscriptionPlan.getPrice());
            pstm.setInt(6, subscriptionPlan.getStoreLimit());
            pstm.setString(7, subscriptionPlan.getCompany().getCnpj());
            pstm.execute();//executando o comando sql

            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO DE SELEÇÃO DOS REGISTROS NO BANCO
    public List<SubscriptionPlan> list(){
        Company company = null;
        List<SubscriptionPlan> subscriptionPlans = new ArrayList<>();

        try {
            String sql = "SELECT * FROM subscriptionplan";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro
            ResultSet resultSet = pstm.executeQuery();//aramazenando o resultado da minha consulta ao ser executado

            while (resultSet.next()){//enquanto tiver resultado ...
                int id = resultSet.getInt("id");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String description = resultSet.getString("description");
                String status = resultSet.getString("status");
                LocalDate registrationDate = resultSet.getDate("creationdate").toLocalDate();
                double price = resultSet.getDouble("price");
                int storeLimit = resultSet.getInt("storelimit");

                String cnpj = resultSet.getString("companycnpj");

                company = new CompanyDAO().find(cnpj);//retorno um objeto

                subscriptionPlans.add(new SubscriptionPlan(id, description, status, registrationDate, price, storeLimit, company));// passo os objetos para o array

            }
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return subscriptionPlans;
    }

    //METODO DE ATUALIZAÇÃO DOS REGISTROS NO BANCO
    public boolean update(SubscriptionPlan subscriptionPlan){
        try {
            String sql = "UPDATE subscriptionplan SET description = ?, status = ?, creationdate = ?, price = ?, storelimit = ?, companycnpj = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, subscriptionPlan.getDescription());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, subscriptionPlan.getStatus());
            pstm.setObject(3, subscriptionPlan.getRegistrationDate());
            pstm.setDouble(4, subscriptionPlan.getPrice());
            pstm.setInt(5, subscriptionPlan.getStoreLimit());
            pstm.setObject(6, subscriptionPlan.getCompany());
            pstm.execute();//executando o comando sql

            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO DE DELEÇÃO DOS REGISTROS NO BANCO
    public boolean delete(int id){
        try {
            String sql = "DELETE FROM subscriptionplan WHERE id = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1, id);//passo o parâmetro para a identificação do registro no comando sql
            pstm.execute();//executando o comando sql

            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
