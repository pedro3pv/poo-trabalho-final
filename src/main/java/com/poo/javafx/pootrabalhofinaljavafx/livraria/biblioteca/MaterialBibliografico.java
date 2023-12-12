package com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TituloInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class MaterialBibliografico implements Catalogavel, Serializable {
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
    public ArrayList dados(){
        ArrayList dados = new ArrayList<>();
        dados.add(titulo);
        dados.add(numeroDePaginas);
        dados.add(ISBN);
        dados.add(autor);
        dados.add(emprestado);
        dados.add(this.getClass().getSimpleName());
        return dados;
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
