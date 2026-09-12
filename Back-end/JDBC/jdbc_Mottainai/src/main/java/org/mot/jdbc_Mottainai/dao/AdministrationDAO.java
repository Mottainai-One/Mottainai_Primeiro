package org.mot.jdbc_Mottainai.dao;

import org.mot.jdbc_Mottainai.connection.DataBaseConnection;
import org.mot.jdbc_Mottainai.model.Administration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministrationDAO {

    //CONSTRUTOR
    public AdministrationDAO() { // construtor vazio, pois quero apenas usar os metodos
    }

    //METODO DE ATUALIZAÇÃO DOS REGISTROS NO BANCO
    public boolean update(Administration administration){ // metodo de atualização no banco
        try{
            String sql = "UPDATE administration SET email = ?, password = ? WHERE id = ?"; //comando de atualização dos registros no banco

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão
            PreparedStatement pstm = connection.prepareStatement(sql);//preparando execução do comando

            pstm.setString(1, administration.getEmail());// substituindo as ocorrências de "?" pelas informações do objeto
            pstm.setString(2, administration.getPassword());
            pstm.setInt(3, administration.getId());
            pstm.execute();//executando o comando no banco

            return true;

        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE.getMessage());
        }
    }
    //METODO DE INSERÇÃO DOS REGISTROS NO BANCO
    public boolean insert(Administration administration){ //metodo para inserir um registro no banco
        try{
            String sql = "INSERT INTO administration(email, password) VALUES (?,?)"; //comando sql

            Connection connection = DataBaseConnection.getInstance().connection(); //abrindo conexão para atualização no banco
            PreparedStatement pstm = connection.prepareStatement(sql); //preparando comando sql

            pstm.setString(1, administration.getEmail());// na primeira ocorrencia do "?" eu substituo por um valor do objeto passado como parâmetro
            pstm.setString(2, administration.getPassword());
            pstm.execute();// executando o comando sql no banco após a substituição de valores

            return true;

        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE.getMessage());
        }
    }

    //METODO DE DELEÇÃO DOS REGISTROS NO BANCO
    public boolean delete(int id){// metodo para apagar o registro no banco
        try{
            String sql = "DELETE FROM administration WHERE id = ?";

            Connection connection = DataBaseConnection.getInstance().connection();//abrindo conexão para aplicação do metodo
            PreparedStatement pstm = connection.prepareStatement(sql);// preparando a execução do comando sql

            pstm.setInt(1,id);// estou atualizando o comando sql, só na debaixo que após o comando sql for retificado aí roda o comando sql
            pstm.execute(); // a linha de cima colocou o id parâmetro para a primeira ocorrência ao ser substituído o comando é executado e o cliente apagado

            return true;

        } catch (SQLException sqlE) {
            throw new RuntimeException(sqlE.getMessage());
        }

    }

    //METODO DE SELEÇÃO DOS REGISTROS NO BANCO
    public List<Administration> list(){ //metodo de listagem da tabela de administração

        List<Administration> administrations = new ArrayList<>(); // Array que irá armazenar os dados e dar o retorno para o metodo

        try {//abrindo try para não quebrar a apicação

            String sql = "SELECT * FROM administration" ;// fazendo o comando sql como forma de String para passar para a classe que iira executar o comando depois

            Connection connection = DataBaseConnection.getInstance().connection(); //abrindo conexao para acessar o banco com o metodo de listagem
            PreparedStatement pstm = connection.prepareStatement(sql); // preparando o comando sql atraves de uma variavel da classe PreparedStatement
            ResultSet resultSet = pstm.executeQuery(); //executando minha query atraves do comando sql que passamos de parametro para o PreparedStatement e armazenando/guardando os dados na variável da classse Resultset

            while (resultSet.next()){ // enquanto ainda tiver resultado...
                int id = resultSet.getInt("id"); // declaro uma variável para cada coluna do meu banco
                String email = resultSet.getString("email");// pego os valores pelo nome da coluna e armazeno nas variáveis
                String password = resultSet.getString("password");

                administrations.add(new Administration(id, email, password)); //ao final, coloco cada variável como parâmetro para o construtor de Administration (para a criação do objeto) e já insiro o objeto na lista para o resultado do metodo
            }
        } catch (SQLException sqlE) { //EXCEÇÃO
            throw new RuntimeException(sqlE.getMessage());//descrição do erro
        }
        return administrations;//retorno do metodo
    }


}
