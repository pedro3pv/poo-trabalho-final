import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

import java.io.Serializable;

public class Devolucao extends Transacao implements Serializable {
    private Emprestimo emprestimo;
    public Devolucao(Emprestimo emprestimo, Pessoa pessoa, MaterialBibliografico livro) {
        super(pessoa, livro);
        this.emprestimo = emprestimo;
        livro.realizarDevolucao();
    }
    private Devolucao(){}

    @Override
    public String toString() {
        return "Devolucao{" +
                "emprestimo=" + emprestimo +
                ", ID=" + ID +
                ", pessoa=" + pessoa +
                ", livro=" + livro +
                ", data='" + data + '\'' +
                '}';
    }
}
