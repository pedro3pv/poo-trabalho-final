import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Emprestimo extends Transacao {
    private String dataDeDevolucao;
    public Emprestimo(Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        livro.realizarEmprestimo();
    }

    @Override
    public String toString() {
        return "Emprestimo" +
                ", "+ ID +
                ", " + pessoa +
                ", " + livro +
                ", " + data +
                ", " + dataDeDevolucao;
    }
}
