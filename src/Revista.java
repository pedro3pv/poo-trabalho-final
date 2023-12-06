import biblioteca.MaterialBibliografico;

import java.io.Serializable;
import java.util.ArrayList;

public class Revista extends MaterialBibliografico implements Serializable {
  public Revista(String titulo, int numeroDePaginas, int iSBN, String autor) {
    super(titulo, numeroDePaginas, iSBN, autor);
  }
  public Revista(){
    super();
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
