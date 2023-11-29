package biblioteca;

import java.util.ArrayList;

public abstract class Pessoa {
  private String nome;
  private int idade;
  private String CPF;
  private ArrayList listaDeLivrosEmprestado = new ArrayList<MaterialBibliografico>(3);

  public Pessoa(String nome, int idade, String CPF) {
    this.nome = nome;
    this.idade = idade;
    this.CPF = CPF;
  }
}