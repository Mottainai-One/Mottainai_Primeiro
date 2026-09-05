package org.mot.jdbc_Mottainai.connection;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class DataBaseConnection {// classe que vai referenciar minha conexão com o banco

    //ATRIBUTOS
    private static DataBaseConnection instance;
    private Connection connection;

    //construtor privado
    private DataBaseConnection() {
        Dotenv dotenv = Dotenv.load();
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");


        try { //abrindo a conexão com o banco, dentro do try para que a aplicação não quebre
            connection = DriverManager.getConnection(url, user, password);
        }catch (SQLException sqlE){
            throw new RuntimeException ("Ocorereu um erro");
        }
    }
    //unico metodo de entrada para a conexao com o banco
    public static DataBaseConnection getInstance() {
        if (Objects.isNull(instance)){
            instance = new DataBaseConnection();
        }
        return instance;
    }

    public Connection connection(){ //metodo responsavel pelo retorno da conexão
        return connection;
    }
}
