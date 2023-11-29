package biblioteca;

import java.util.ArrayList;

public abstract class Pessoa {
  protected String nome;
  protected int idade;
  protected String CPF;
  protected ArrayList listaDeLivrosEmprestado = new ArrayList<MaterialBibliografico>(3);

  public Pessoa(String nome, int idade, String CPF) {
    this.nome = nome;
    this.idade = idade;
    this.CPF = CPF;
  }
}