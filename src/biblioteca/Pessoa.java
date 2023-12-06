package biblioteca;

import Excecoes.IdadeInvalidaException;

import java.util.ArrayList;

public abstract class Pessoa implements Cadastravel {
  protected String nome;
  protected int idade;
  protected String CPF;
  protected ArrayList listaDeLivrosEmprestado = new ArrayList<MaterialBibliografico>(3);

  public Pessoa(String nome, int idade, String CPF) throws IdadeInvalidaException {
    if (idade < 18) {
      throw new IdadeInvalidaException("Idade inválida. O cliente deve ter pelo menos 18 anos.");
    }
    this.nome = nome;
    this.idade = idade;
    this.CPF = CPF;
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