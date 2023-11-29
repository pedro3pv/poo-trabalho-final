import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Emprestimo extends Transacao {
    public Emprestimo(Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        livro.realizarEmprestimo();
    }

    @Override
    public String toString() {
        return ID +
                ", " + pessoa +
                ", " + livro +
                ", " + data ;
    }
}
