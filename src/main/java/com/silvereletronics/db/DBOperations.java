package com.silvereletronics.db;

import com.silvereletronics.Componente;

import java.sql.*;
import java.util.*;

public class DBOperations {
    public static int create(Componente comp){
        String sql = "INSERT INTO componentes (nome, quantidade) VALUES (?, ?)";
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, comp.getNome());
            stmt.setInt(2, comp.getQuantidade());
            return stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("Erro ao adicionar componente: " + e.getMessage());
        }
        return 0;
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

    public static void update(int id, String nome, int quantidade) {
        String sql = "UPDATE componentes SET nome = ?, quantidade = ? WHERE id = ?";
        try(Connection conn = DBConnect.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, quantidade);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar componente no banco de dados: " + e.getMessage());
        }
    }
    public static void delete(int id){
        String sql = "DELETE FROM componentes WHERE id = ?";
        try(Connection conn = DBConnect.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("ID não existe " + e.getMessage());
        }
    }

    public static int getMaxID(){
        int id;
        try(Connection conn = DBConnect.getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(id) AS total FROM componentes");
            ResultSet rs = stmt.executeQuery()){
            if(rs.next()){
                id = rs.getInt("total");
                return id;
            }
        }catch (SQLException e){
            System.out.println("Erro de conexão" + e.getMessage());
        }
         return 0;
    }
}
