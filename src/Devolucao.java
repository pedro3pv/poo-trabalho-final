import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Devolucao extends Transacao {
    public Devolucao(int ID, Pessoa pessoa, MaterialBibliografico livro) {
        super(ID, pessoa, livro);
        livro.realizarDevolucao();
    }
}
