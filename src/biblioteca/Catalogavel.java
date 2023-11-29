package biblioteca;

public interface Catalogavel {
  boolean emprestado = false;
  void realizarEmprestimo();
  void realizarDevolucao();
  default boolean status(){
    return emprestado;
  }
}