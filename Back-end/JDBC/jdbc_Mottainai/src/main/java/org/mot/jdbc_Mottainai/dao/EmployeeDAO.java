package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Employee;
import org.mot.jdbc_Mottainai.model.Store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    //CONSTRUTOR
    public EmployeeDAO() {
    }

    //METODO  DE LISTAGEM DOS REGISTROS
    public List<Employee> list(){

        Store store = null;
        List<Employee> employees = new ArrayList<>();

        try {
            String sql =  "SELECT * FROM employee";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro
            ResultSet resultSet = pstm.executeQuery();//executando a consulta

            while (resultSet.next()){//enquanto ainda tiver resultado...
                String cpf = resultSet.getString("cpf");//pego o valor armazenado em cada coluna pelo nome da coluna
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                LocalDate employmentDate = resultSet.getDate("employmentdate").toLocalDate();

                int storeCode  = resultSet.getInt("storecode");

                store = new StoreDAO().find(storeCode);//chamo o metodo para me retornar o objeto adequado

                employees.add(new Employee(cpf,name, surname, birthDate, employmentDate, store));//instancio um novo objeto e adiciono no array

            }
            //EXCEÇÃO
        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE.getMessage());
        }
        return employees;
    }

    //METODO DE INSERÇÃO DE REGISTRO NO BANCO
    public boolean insert(Employee employee){

        try{
            String sql = "INSERT INTO employee(cpf, name, surname, birthdate, employmentdate, storecode) VALUES (?,?,?,?,?,?)";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1,employee.getCpf());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, employee.getName());
            pstm.setString(3, employee.getSurname());
            pstm.setObject(4, employee.getBirthDate());
            pstm.setObject(5,employee.getEmploymentDate());
            pstm.setObject(6, employee.getStore().getStoreCode());
            pstm.execute();
            return true;

        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE);
        }
    }

    //METODO DE ATUALIZAÇÃO DOS REGISTROS NO BANCO
    public boolean update(Employee employee){
        try {
            String sql = "UPDATE employee SET name = ?, surname = ?, birthdate = ?, employmentdate = ?, storecode = ? WHERE cpf = ?"; //comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, employee.getName());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, employee.getSurname());
            pstm.setObject(3, employee.getBirthDate());
            pstm.setObject(4, employee.getEmploymentDate());
            pstm.setInt(5, employee.getStore().getStoreCode());
            pstm.setString(6, employee.getCpf());
            pstm.execute();//executando meu comando sql
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO QUE APAGA UM REGISTRO NO BANCO
    public boolean delete(String cpf){
        try {
            String sql = "DELETE FROM employee WHERE cpf = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, cpf);//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.execute();//executando meu comando sql
            return true;
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO QUE RETORNA UM OBJETO ESPECÍFICO
    public Employee find(String cpf){
        Store store = null;
        Employee employee = null;

        try {
            String sql = "SELECT * FROM employee WHERE cpf = ?";//comando sql

            Connection connection =DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, cpf);//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            ResultSet resultSet = pstm.executeQuery();//aramazenando o resultado da minha consulta ao ser executado

            if (resultSet.next()){
                String cpf1 = resultSet.getString("cpf");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                LocalDate birthDate = resultSet.getDate("birthdate").toLocalDate();
                LocalDate employmentDate = resultSet.getDate("employmentdate").toLocalDate();

                int storecode = resultSet.getInt("storecode");

                store = new StoreDAO().find(storecode);//retorno o objeto store
                employee = new Employee(cpf1, name,surname,birthDate, employmentDate, store);// instancio um novo objeto
            }

            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }
}
