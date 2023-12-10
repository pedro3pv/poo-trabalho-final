package com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TituloInvalidoException;

public abstract class MaterialBibliografico implements Catalogavel {
    protected String titulo;
    protected int numeroDePaginas;
    protected int ISBN;
    protected String autor;
    protected boolean emprestado;

    public MaterialBibliografico(String titulo, int numeroDePaginas, int ISBN, String autor) throws TituloInvalidoException {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new TituloInvalidoException("Título inválido. O título não pode ser nulo ou vazio.");
            }
            this.titulo = titulo;
            this.numeroDePaginas = numeroDePaginas;
            this.ISBN = ISBN;
            this.autor = autor;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    protected MaterialBibliografico(){}

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
