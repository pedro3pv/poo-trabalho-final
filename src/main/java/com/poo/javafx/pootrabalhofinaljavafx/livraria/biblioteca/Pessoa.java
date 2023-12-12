package com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.IdadeInvalidaException;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Pessoa implements Cadastravel, Serializable {
  protected String nome;
  protected int idade;
  protected String CPF;
  protected ArrayList listaDeLivrosEmprestado = new ArrayList<MaterialBibliografico>(3);

  public Pessoa() {
  }

  public Pessoa(String nome, int idade, String CPF) throws IdadeInvalidaException {
    if (idade < 18) {
      throw new IdadeInvalidaException("Idade inválida. O cliente deve ter pelo menos 18 anos.");
    }
    this.nome = nome;
    this.idade = idade;
    this.CPF = CPF;
  }

  public ArrayList getListaDeLivrosEmprestado() {
    return listaDeLivrosEmprestado;
  }

  public String getNome() {
    return nome;
  }

  public void setListaDeLivrosEmprestado(ArrayList listaDeLivrosEmprestado) {
    this.listaDeLivrosEmprestado = listaDeLivrosEmprestado;
  }

  public void adicionarLivroEmprestado(MaterialBibliografico livroEmprestado) {
    try {
      if (listaDeLivrosEmprestado.size() <= 3) {
        livroEmprestado.realizarEmprestimo();
        listaDeLivrosEmprestado.add(livroEmprestado);
      } else {
        System.out.println("lá tem 3 livros emprestado");
      }
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  @Override
  public String toString() {
    return "Pessoa{" +
            "nome='" + nome + '\'' +
            ", idade=" + idade +
            ", CPF='" + CPF + '\'' +
            ", listaDeLivrosEmprestado=" + listaDeLivrosEmprestado +
            '}';
  }
}