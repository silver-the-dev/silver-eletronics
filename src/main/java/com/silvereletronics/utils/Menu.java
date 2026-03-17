package com.silvereletronics.utils;

import com.silvereletronics.Componente;
import com.silvereletronics.db.DBOperations;

import javax.sound.midi.Soundbank;
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

    public static void atualizar(int id, String nome, int quantidade) {
        DBOperations.update(id, nome, quantidade);
    }
    public static void deletar(int id) {

        DBOperations.delete(id);

    }

    public static void menu() {
        System.out.println("==================Gerenciamento de Componentes===============");
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Listar.");
        System.out.println("2 - Inserir.");
        System.out.println("3 - Atualizar.");
        System.out.println("4 - Deletar.");

        System.out.println("Opção: ");
        int opcao = DataInput.IntegerInput(1,4);
        if (opcao == 1) {
            listarValores();
        } else if (opcao == 2) {
            System.out.println("Digite o nome do componente: ");
            String nome = DataInput.TextInput();
            System.out.println("Digite a quantidade de componentes disponíveis");
            int quantidade = DataInput.IntegerInput();
            inserir(nome, quantidade);
            System.out.println("Item inserido com sucesso");
        } else if (opcao == 3) {
            System.out.println("Digite o novo nome: ");
            String nome = DataInput.TextInput();
            System.out.println("Digite a nova quantidade: ");
            int quantidade = DataInput.IntegerInput();
            System.out.println("Digite o ID do item à aplicar estas modificações");
            int id = DataInput.IntegerInput(1, DBOperations.getMaxID());
            atualizar(id, nome, quantidade);
            System.out.println("Item atualizado com sucesso");
        } else if (opcao == 4) {
            System.out.println("Digite o ID do produto a remover: ");
            int id = DataInput.IntegerInput();
            deletar(id);
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
