package com.silvereletronics.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnect {
    static String URL;
    static String USER;
    static String PASSWORD;
    public static String DB;

    public static Connection getConnection(){
        Properties props = new Properties();

        try(FileInputStream fis = new FileInputStream("config.properties")){
            props.load(fis);
            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");
            DB = props.getProperty("db.db");
        } catch(IOException e){
            System.out.println("Não foi possível recuperar o usuário e senha para acessar o banco de dados:" + e.getMessage());
        }

        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(Exception e){
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            return null;
        }
    }
}
