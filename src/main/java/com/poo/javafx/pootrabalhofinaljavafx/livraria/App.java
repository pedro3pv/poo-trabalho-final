package com.poo.javafx.pootrabalhofinaljavafx.livraria;

public class App {
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro("test",15,3515,"test");
        biblioteca.adicionarLivro("test2",14,3516,"test2");

        Cliente cliente = new Cliente("cleber",180,"5656793256753");

        biblioteca.emprestimo(cliente, biblioteca.getMaterialBibliografico(3516));
        biblioteca.adicionarLivro("test3",14,3517,"test3");
        biblioteca.adicionarLivro("test4",14,3518,"test4");
        biblioteca.adicionarLivro("test5",14,3519,"test5");
        biblioteca.adicionarRevista("test6",14,3520,"test6");
        biblioteca.adicionarRevista("test7",14,3521,"test7");
        biblioteca.adicionarRevista("test8",14,3522,"test8");
        //biblioteca.devolucao(cliente, biblioteca.getMaterialBibliografico(3515));
        biblioteca.devolucao(cliente, biblioteca.getMaterialBibliografico(3516));
        //biblioteca.removerMaterialBibliografico(3515);
        //biblioteca.removerMaterialBibliografico(3516);
    }
}
