package com.silvereletronics.db;

import com.silvereletronics.Componente;

import java.sql.*;
import java.util.*;

public class DBOperations {
    public static void create(Componente comp){
        String sql = "INSERT INTO componentes (nome, quantidade) VALUES (?, ?)";
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, comp.getNome());
            stmt.setInt(2, comp.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("Erro ao adicionar componente: " + e.getMessage());
        }
    }

    public static List<Componente> read() {
        String sql = "SELECT * FROM componentes";
        List<Componente> componentes = new ArrayList<>();
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet res = stmt.executeQuery()){
            while (res.next()) {
                int id = res.getInt(1);
                String nome = res.getString(2);
                int quantidade = res.getInt(3);
                componentes.add(new Componente(id, nome, quantidade));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar componentes no banco de dados: " + e.getMessage());
        }
        return componentes;
    }

    public static void update(){

    }
    public static void delete(){

    }
}
