package Excecoes;

public class LivroJaEmprestadoException extends Exception {
    public LivroJaEmprestadoException(String mensagem) {
        super(mensagem);
    }

    @Override
    public String toString() {
        return "LivroJaEmprestadoException{}";
    }
}
