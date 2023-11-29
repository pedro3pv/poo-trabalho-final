import biblioteca.MaterialBibliografico;

import java.util.ArrayList;

public class Livro extends MaterialBibliografico {
  public Livro(String titulo, int numeroDePaginas, int ISBN, String autor) {
    super(titulo, numeroDePaginas, ISBN, autor);
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
