package biblioteca;

public abstract class MaterialBibliografico implements Catalogavel {
    protected String titulo;
    protected int numeroDePaginas;
    protected int ISBN;
    protected String autor;
    protected boolean emprestado;
    public MaterialBibliografico(String titulo, int numeroDePaginas, int ISBN, String autor) {
        this.titulo = titulo;
        this.numeroDePaginas = numeroDePaginas;
        this.ISBN = ISBN;
        this.autor = autor;
    }
    @Override
    public void realizarEmprestimo() {
        emprestado = true;
    }

    @Override
    public void realizarDevolucao() {
        emprestado = false;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean status(){
        return emprestado;
    }
    @Override
    public String toString() {
        return "MaterialBibliografico" +
                ", " + titulo +
                ", " + numeroDePaginas +
                ", " + ISBN +
                ", " + autor +
                ", " + emprestado;
    }
}
