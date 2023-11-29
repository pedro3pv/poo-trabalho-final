package biblioteca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Transacao {
    private int ID;
    private Pessoa pessoa;
    private MaterialBibliografico livro;
    private String data;
    private String hora;
    public Transacao(int ID,Pessoa pessoa, MaterialBibliografico livro) {
        LocalDateTime hour = LocalDateTime.now();
        DateTimeFormatter formatHour = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = hour.format(formatHour);
        this.pessoa = pessoa;
        this.livro = livro;
        this.data = formattedDate;
    }

}
