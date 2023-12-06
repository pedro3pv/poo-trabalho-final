import Excecoes.TituloInvalidoException;
import biblioteca.MaterialBibliografico;

import java.io.Serializable;
import java.util.ArrayList;

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
