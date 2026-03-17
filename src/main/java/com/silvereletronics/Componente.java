package com.silvereletronics;

public class Componente {
    int id;
    String nome;
    int quantidade;

    public Componente(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Componente(int id, String nome, int quantidade){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
