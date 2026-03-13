package com.silvereletronics.db;

import java.sql.*;

public class DBOperations {
    public static void create(){

    }
    public static void read(){

    }
    public static void update(){

    }
    public static void delete(){

    }
    public static void listColumns(){
        String sql = "SELECT * FROM componentes";
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery()){

            ResultSetMetaData metaData = res.getMetaData();
            int columnCount = metaData.getColumnCount();

            for(int i = 1; i <= columnCount; i++){
                String getColumnName = metaData.getColumnName(i);
                String formatColumnName = getColumnName.substring(0, 1).toUpperCase() + getColumnName.substring(1);
                System.out.println(i + " - " + formatColumnName);
            }
            System.out.println(columnCount+1 + " - Todas");

        } catch (SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
