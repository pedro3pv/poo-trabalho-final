import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

public class Devolucao extends Transacao {
    private Emprestimo emprestimo;
    public Devolucao(Emprestimo emprestimo, Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        this.emprestimo = emprestimo;
        livro.realizarDevolucao();
    }

    @Override
    public String toString() {
        return "Devolucao" +
                ", "+ ID +
                ", " + pessoa +
                ", " + livro +
                ", " + data +
                ", " + emprestimo;
    }
}
