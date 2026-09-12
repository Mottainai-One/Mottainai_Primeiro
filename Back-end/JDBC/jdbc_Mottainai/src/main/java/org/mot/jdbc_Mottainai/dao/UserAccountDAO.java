package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Employee;
import org.mot.jdbc_Mottainai.model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserAccountDAO {

    //CONSTRUTOR
    public UserAccountDAO() {
    }

    //METODO DE INSERÇÃO DOS REGISTROS NO BANCO
    public boolean insert(UserAccount userAccount){
        try {
            String sql = "INSERT INTO useraccount VALUES (?,?,?,?,?,?,?,?,?)";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setInt(1,userAccount.getId());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, userAccount.getUserName());
            pstm.setString(3, userAccount.getEmail());
            pstm.setString(4, userAccount.getPassword());
            pstm.setObject(5, userAccount.getRegistrationDate());
            pstm.setObject(6, userAccount.getLastAcces());
            pstm.setString(7, userAccount.getStatus());
            pstm.setString(8, userAccount.getPosition());
            pstm.setString(9, userAccount.getEmployeeCpf().getCpf());
            pstm.execute();//executando o comando sql

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //METODO DE SELEÇÃO DOS REGISTROS NO BANCO
    public List<UserAccount> list(){
        List<UserAccount> userAccounts = new ArrayList<>();
        Employee employee = null;
        try {
            String sql = "SELECT * FROM useraccount";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//estabelecendo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro
            ResultSet resultSet = pstm.executeQuery();//aramazenando o resultado da minha consulta ao ser executado

            while (resultSet.next()){//enquanto ainda tiver resultado ...
                int id = resultSet.getInt("id");// declaro uma variável para cada dado que tem no banco de acordo com o nome da coluna
                String userName = resultSet.getString("username");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDate registrationDate = resultSet.getDate("registrationdate").toLocalDate();
                LocalDateTime lastAcces = resultSet.getTimestamp("lastaccess").toLocalDateTime();
                String status = resultSet.getString("status");
                String position = resultSet.getString("position");

                String cpf = resultSet.getString("employeecpf");

                employee = new EmployeeDAO().find(cpf);//retorno um objeto específico

                userAccounts.add(new UserAccount(id,userName, email, password, registrationDate, lastAcces, status, position, employee));//passo um objeto para o array
            }
            //EXCEÇÃO
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userAccounts;
    }

    //METODO DE ATUALIZAÇÃO DOS REGISTROS NO BANCO
    public boolean update(UserAccount userAccount){
        try {
            String sql =  "UPDATE useraccount SET username = ?, email=?, password = ?, registrationdate = ?, lastaccess = ?, status= ?, position = ?, employeecpf = ? WHERE id = ?";//comando sql

            Connection connection = DataBaseConnection.getInstance().connection();//comando sql
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando o comando, passando o sql como parametro

            pstm.setString(1, userAccount.getUserName());//a cada ocorrencia de "?" no comando eu passo uma informação do objeto para ser substituida
            pstm.setString(2, userAccount.getEmail());
            pstm.setString(3, userAccount.getPassword());
            pstm.setObject(4, userAccount.getRegistrationDate());
            pstm.setObject(5, userAccount.getLastAcces());
            pstm.setString(6, userAccount.getStatus());
            pstm.setString(7, userAccount.getPosition());
            pstm.setString(8, userAccount.getEmployeeCpf().getCpf());
            pstm.setInt(9,userAccount.getId());
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
            String sql = "DELETE FROM useraccount WHERE id = ?";//comando sql

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
