package com.poo.javafx.pootrabalhofinaljavafx.livraria;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TituloInvalidoException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.MaterialBibliografico;

import java.io.Serializable;

public class Livro extends MaterialBibliografico implements Serializable {
  public Livro(String titulo, int numeroDePaginas, int ISBN, String autor) throws TituloInvalidoException {
    super(titulo, numeroDePaginas, ISBN, autor);
  }

  private Livro(){
      super();
  }
  @Override
  public String toString() {
    return "Livro" +
            ", " + titulo +
            ", " + numeroDePaginas +
            ", " + ISBN +
            ", " + autor +
            ", " + emprestado;
  }
}
