package com.silvereletronics.db;

import com.silvereletronics.utils.DataInput;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.*;

public class DBOperations {
    public static void create(){

    }

    public static List<Map<Integer, List<Object>>> read(String database) {
        String sql = "SELECT * FROM " + database;
        List<Map<Integer, List<Object>>> result = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            ResultSetMetaData metaData = res.getMetaData();

            while (res.next()) {
                Map<Integer, List<Object>> map = new HashMap<>();
                List<Object> list = new ArrayList<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    int id = res.getInt(1);
                    if(i > 1) list.add(res.getObject(i));
                    map.put(id, list);
                }
                result.add(map);
            }
        } catch (SQLException e) {
            System.out.println("Erroso: " + e.getMessage());
        }
        return result;
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
