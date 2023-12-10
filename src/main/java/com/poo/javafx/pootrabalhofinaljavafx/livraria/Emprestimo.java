package com.poo.javafx.pootrabalhofinaljavafx.livraria;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TransacaoInvalidaException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.MaterialBibliografico;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Pessoa;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Transacao;

import java.io.Serializable;

public class Emprestimo extends Transacao implements Serializable {
    private String dataDeDevolucao;
    public Emprestimo(Pessoa pessoa, MaterialBibliografico livro) throws TransacaoInvalidaException {
        super(pessoa, livro);
        livro.realizarEmprestimo();
    }
    private Emprestimo(){}

    @Override
    public String toString() {
        return "Emprestimo{" +
                "dataDeDevolucao='" + dataDeDevolucao + '\'' +
                ", ID=" + ID +
                ", pessoa=" + pessoa +
                ", livro=" + livro +
                ", data='" + data + '\'' +
                '}';
    }
}
