package com.silvereletronics.utils;

import com.silvereletronics.db.DBOperations;

public class Menu {

    public static void inserir() {
        DBOperations.create();
    }
    public static void listar() {
        DBOperations.read();
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
        System.out.println("3 - Atualizar.");
        System.out.println("4 - Deletar.");

        System.out.println("Opção: ");
        int opcao = DataInput.IntegerInput();
        if (opcao == 1) {
            listar();
        } else if (opcao == 2) {
            inserir();
        } else if (opcao == 3) {
            atualizar();
        } else if (opcao == 4) {
            deletar();
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
