package com.silvereletronics.db;

import com.silvereletronics.utils.DataInput;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.*;

public class DBOperations {
    public static void create(){
        
    }
    public static void read(){
        String sql = "SELECT * FROM ";
        int columnCount = 0;
        try(Connection conn = DBConnect.getConnection()){
            sql = sql + selectTable();

            PreparedStatement stmt = conn.prepareStatement(sql);
            System.out.println(stmt);
            ResultSet res = stmt.executeQuery();
            ResultSetMetaData metaData = res.getMetaData();
            columnCount = metaData.getColumnCount();

            System.out.println("Selecione a coluna que deseja filtrar: " + columnCount);
            for(int i = 1; i <= columnCount; i++){
                String getColumnName = metaData.getColumnName(i);
                String formatColumnName = getColumnName.substring(0, 1).toUpperCase() + getColumnName.substring(1);
                System.out.println(i + " - " + formatColumnName);
            }
            System.out.println(columnCount + 1 + " - Todas");

            int coluna = DataInput.IntegerInput(1, columnCount + 1);

            if(coluna <= columnCount) {
                System.out.println("Coluna: " + metaData.getColumnLabel(coluna));
            }else {
                StringBuilder colunas = new StringBuilder();
                for(int i = 1; i <= columnCount; i++){
                    String label = metaData.getColumnLabel(i).toUpperCase();
                    colunas.append(String.format("%-10s", label));
                }
                colunas.append("\n");
                System.out.println(colunas);
            }
            while (res.next()) {
                if(coluna <= columnCount){
                    System.out.println(res.getObject(coluna).toString());
                }
                if(coluna == columnCount + 1){
                    StringBuilder colunas = new StringBuilder();
                    for(int i = 1; i <= columnCount; i++){
                        String column = res.getObject(i).toString();
                        colunas.append(String.format("%-10s", column));
                    }
                    System.out.println(colunas);
                }
            }
        } catch (SQLException e){
            System.out.println("Erroso: " + e.getMessage());
        }
    }
    public static void update(){

    }
    public static void delete(){

    }
    public static String selectTable() {
        Map<Integer, String> tabelas = new HashMap<>();
        int i = 1;
        try(Connection conn = DBConnect.getConnection();){
            System.out.println("Conectado");
            DatabaseMetaData dbMD = conn.getMetaData();
            String[] tipos = {"TABLE"};
            try(ResultSet rs = dbMD.getTables(DBConnect.DB, null, "%", tipos)){
                while (rs.next()){
                    tabelas.put(i, rs.getString("TABLE_NAME"));
                    System.out.println(i + " - " + rs.getString("TABLE_NAME"));
                    i++;
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int valor = DataInput.IntegerInput(1, i-1);
        System.out.println(tabelas.get(valor));
        return tabelas.get(valor);
    }
}
