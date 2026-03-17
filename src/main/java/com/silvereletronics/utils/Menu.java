package com.silvereletronics.utils;

import com.silvereletronics.Componente;
import com.silvereletronics.db.DBOperations;

import java.util.List;

public class Menu {

    public static void inserir(String nome, int quantidade) {
        DBOperations.create(new Componente(nome, quantidade));
    }

    public static void listarValores() {
        List<Componente> list = DBOperations.read();
        System.out.printf("%-5s %-35s %-5s\n", "ID", "NOME", "QUANTIDADE");
        for(Componente componente : list) {
            int id = componente.getId();
            String nome = componente.getNome();
            int quantidade = componente.getQuantidade();
            System.out.printf("%-5s %-35s %-5s\n", id, nome, quantidade);
        }
    }

    public static void atualizar() {
        DBOperations.update();
    }
    public static void deletar() {
        DBOperations.delete();
    }

    public static void menu() {
        System.out.println("==================Gerenciamento de Componentes===============");
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Listar.");
        System.out.println("2 - Inserir.");
        //System.out.println("3 - Atualizar.");
        //System.out.println("4 - Deletar.");

        System.out.println("Opção: ");
        int opcao = DataInput.IntegerInput(1,2);
        if (opcao == 1) {
            listarValores();
        } else if (opcao == 2) {
            inserir("Resistor genérico", 123);
        } else if (opcao == 3) {
            atualizar();
        } else if (opcao == 4) {
            deletar();
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
