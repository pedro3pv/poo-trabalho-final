package biblioteca;

import Excecoes.TransacaoInvalidaException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transacao implements Acontecimentos{
    protected int ID;
    protected Pessoa pessoa;
    protected MaterialBibliografico livro;
    protected String data;
    public Transacao(Pessoa pessoa, MaterialBibliografico livro) throws TransacaoInvalidaException {
        if (pessoa == null || livro == null) {
            throw new TransacaoInvalidaException("Pessoa e/ou MaterialBibliografico não podem ser nulos.");
        }
        LocalDateTime hour = LocalDateTime.now();
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = hour.format(formatHour);
        this.pessoa = pessoa;
        this.livro = livro;
        this.data = formattedDate;
    }

    public Transacao() {

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
