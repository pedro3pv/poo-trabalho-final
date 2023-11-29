package biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transacao {
    protected int ID;
    protected Pessoa pessoa;
    protected MaterialBibliografico livro;
    protected String data;
    public Transacao(Pessoa pessoa, MaterialBibliografico livro) {
        LocalDateTime hour = LocalDateTime.now();
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = hour.format(formatHour);
        this.pessoa = pessoa;
        this.livro = livro;
        this.data = formattedDate;
    }
}
