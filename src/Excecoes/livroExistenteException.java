package Excecoes;

public class livroExistenteException extends Exception {
    public livroExistenteException(String mensagem) {
        super(mensagem);
    }

    @Override
    public String toString() {
        return "livroExistenteException{}";
    }
}
