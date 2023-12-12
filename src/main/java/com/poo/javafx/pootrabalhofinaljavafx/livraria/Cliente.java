package com.poo.javafx.pootrabalhofinaljavafx.livraria;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.IdadeInvalidaException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Pessoa;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Pessoa implements Serializable {
    public Cliente() {
        super();
    }

    public Cliente(String nome, int idade, String CPF) throws IdadeInvalidaException {
        super(nome, idade, CPF);
    }

    @Override
    public ArrayList dados(){
        ArrayList dados = new ArrayList<>();
        dados.add(nome);
        dados.add(idade);
        dados.add(CPF);
        return dados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", CPF='" + CPF + '\'' +
                ", listaDeLivrosEmprestado=" + listaDeLivrosEmprestado +
                '}';
    }
}
