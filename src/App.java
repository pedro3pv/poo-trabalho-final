public class App {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("test",15,3515,"test");
        biblioteca.adicionarLivro("test2",14,3516,"test2");

        Cliente cliente = new Cliente("cleber",180,"5656793256753");

        biblioteca.emprestimo(cliente, biblioteca.getMaterialBibliografico(3516));
        //biblioteca.removerMaterialBibliografico(3515);
        //biblioteca.removerMaterialBibliografico(3516);
    }
}
