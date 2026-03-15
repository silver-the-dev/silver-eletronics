package com.silvereletronics.db;

import java.sql.*;
import java.util.*;

public class DBOperations {
    public static void create(){

    }

    public static List<Map<Integer, List<Object>>> read(String database) {
        String sql = "SELECT * FROM " + database;
        List<Map<Integer, List<Object>>> result = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery()){
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
            System.out.println("Erro 1: " + e.getMessage());
        }
        return result;
    }
    public static void update(){

    }
    public static void delete(){

    }
}
