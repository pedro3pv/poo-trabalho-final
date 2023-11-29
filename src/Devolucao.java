import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Devolucao extends Transacao {
    public Devolucao(Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        livro.realizarDevolucao();
    }
}
