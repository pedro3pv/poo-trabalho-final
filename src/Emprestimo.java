import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Emprestimo extends Transacao {
    public Emprestimo(int ID, Pessoa pessoa, MaterialBibliografico livro) {
        super(ID, pessoa, livro);
        livro.realizarEmprestimo();
    }
}
