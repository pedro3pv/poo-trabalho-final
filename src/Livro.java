public class Livro implements Catalogavel{
  private String titulo;
  private int numeroDePaginas;
  private int ISBN;
  private String Autor;

  public Livro(String titulo, int numeroDePaginas, int iSBN, String autor) {
    this.titulo = titulo;
    this.numeroDePaginas = numeroDePaginas;
    ISBN = iSBN;
    Autor = autor;
  }

}
