import biblioteca.MaterialBibliografico;

import java.util.ArrayList;

public class Revista extends MaterialBibliografico {
  public Revista(String titulo, int numeroDePaginas, int iSBN, String autor) {
    super(titulo, numeroDePaginas, iSBN, autor);
  }
  @Override
  public String toString() {
    return "Revista" +
            ", " + titulo +
            ", " + numeroDePaginas +
            ", " + ISBN +
            ", " + autor +
            ", " + emprestado;
  }
}
