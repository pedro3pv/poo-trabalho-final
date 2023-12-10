package com.poo.javafx.pootrabalhofinaljavafx.livraria;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TransacaoInvalidaException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.MaterialBibliografico;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Pessoa;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Transacao;

import java.io.Serializable;

public class Devolucao extends Transacao implements Serializable {
    private Emprestimo emprestimo;
    public Devolucao(Emprestimo emprestimo, Pessoa pessoa, MaterialBibliografico livro) throws TransacaoInvalidaException {
        super(pessoa, livro);
        this.emprestimo = emprestimo;
        livro.realizarDevolucao();
    }
    private Devolucao(){}

    @Override
    public String toString() {
        return "Devolucao{" +
                "emprestimo=" + emprestimo +
                ", ID=" + ID +
                ", pessoa=" + pessoa +
                ", livro=" + livro +
                ", data='" + data + '\'' +
                '}';
    }
}
