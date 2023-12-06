import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

import java.io.Serializable;

public class Emprestimo extends Transacao implements Serializable {
    private String dataDeDevolucao;
    public Emprestimo(Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        livro.realizarEmprestimo();
    }
    private Emprestimo(){}
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
