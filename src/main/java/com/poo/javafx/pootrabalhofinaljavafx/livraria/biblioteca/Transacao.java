package com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TransacaoInvalidaException;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Transacao implements Acontecimentos, Serializable {
    protected int ID;
    protected Pessoa pessoa;
    protected MaterialBibliografico livro;
    protected String data;
    public Transacao(Pessoa pessoa, MaterialBibliografico livro) throws TransacaoInvalidaException {
        try {
            if (pessoa == null || livro == null) {
                throw new TransacaoInvalidaException("Pessoa e/ou MaterialBibliografico não podem ser nulos.");
            }
            LocalDateTime hour = LocalDateTime.now();
            DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = hour.format(formatHour);
            this.pessoa = pessoa;
            this.livro = livro;
            this.data = formattedDate;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Transacao() {

    }

    public ArrayList dados(){
        ArrayList<String> dados = new ArrayList<>();
        dados.add(String.valueOf(ID));
        dados.add(pessoa.getNome());
        dados.add((String) livro.dados().get(0));
        dados.add(data);
        dados.add(this.getClass().getSimpleName());
        return dados;
    }

    public MaterialBibliografico getMaterialBibliografico() {
        return livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "ID=" + ID +
                ", pessoa=" + pessoa +
                ", livro=" + livro +
                ", data='" + data + '\'' +
                '}';
    }
}
