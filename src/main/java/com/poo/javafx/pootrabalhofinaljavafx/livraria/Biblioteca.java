package com.poo.javafx.pootrabalhofinaljavafx.livraria;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.*;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.MaterialBibliografico;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Pessoa;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Transacao;

import java.io.Serializable;
import java.util.ArrayList;

public class Biblioteca implements Serializable {
  private ArrayList<MaterialBibliografico> listaDeMaterialBibliografico;
  private ArrayList<Transacao> listaDeTransacoes;
  private ArrayList<Pessoa> listaDePessoas;

  public Biblioteca() {
    listaDeMaterialBibliografico = Persistencia.carregarMaterialBibliografico("./MaterialBibliografico.dat");
    listaDeTransacoes = Persistencia.carregarTransacoes("./Transacoes.dat");
    listaDePessoas = Persistencia.carregarPessoas("./Pessoas.dat");
  }

  private void atualizarArquivoDoMaterialBibliografico(){
    Persistencia.salvarMaterialBibliografico(listaDeMaterialBibliografico,"./MaterialBibliografico.dat");
  }

  private void atualizarArquivoDasTransacoes(){
    Persistencia.salvarTransacoes(listaDeTransacoes,"./Transacoes.dat");
  }
  private void atualizarArquivoDasPessoas(){
    Persistencia.salvarPessoas(listaDePessoas,"./Pessoas.dat");
  }

  private void adicionarMaterialBibliografico(MaterialBibliografico materialBibliografico) throws livroExistenteException {
    boolean contains = false;
    for (int i = 0;i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico obj = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (String.valueOf(materialBibliografico).equals(String.valueOf(obj))){
        contains = true;
        throw new livroExistenteException("livro já existe");
      }
    }
    if (!contains){
      listaDeMaterialBibliografico.add(materialBibliografico);
      System.out.println(materialBibliografico);
      System.out.println("livro adicionado");
    } else {
      System.out.println("livro já está na lista");
    }
    atualizarArquivoDoMaterialBibliografico();
  }
  public void adicionarCliente(String nome, int idade, String cpf) {
      try {
        Cliente cliente = new Cliente(nome,idade,cpf);
          listaDePessoas.add(cliente);
          atualizarArquivoDasPessoas();
      } catch (IdadeInvalidaException e) {
          throw new RuntimeException(e);
      }
  }
  public void adicionarLivro(String titulo, int numeroDePaginas, int iSBN, String autor) throws livroExistenteException, TituloInvalidoException {
    Livro livro = new Livro(titulo,numeroDePaginas,iSBN,autor);
    adicionarMaterialBibliografico(livro);
  }

  public void adicionarRevista(String titulo, int numeroDePaginas, int iSBN, String autor) throws livroExistenteException, TituloInvalidoException {
    Revista revista = new Revista(titulo,numeroDePaginas,iSBN,autor);
    adicionarMaterialBibliografico(revista);
  }

  public MaterialBibliografico getMaterialBibliografico(int iSBN){
    for (int i = 0; i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico materialBibliografico = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (iSBN == materialBibliografico.getISBN()){
        return materialBibliografico;
      }
    }
    return null;
  }

  public void removerMaterialBibliografico(int iSBN) throws LivroNaoExisteException {
    boolean contains = false;
    for (int i = 0; i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico materialBibliografico = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (iSBN == materialBibliografico.getISBN()){
        listaDeMaterialBibliografico.remove(materialBibliografico);
      }
    }
    if (!contains){
      throw new LivroNaoExisteException("livro não existe");
    }
    atualizarArquivoDoMaterialBibliografico();
  }
  public void emprestimo(Pessoa pessoa,MaterialBibliografico materialBibliografico) throws LivroJaEmprestadoException, TransacaoInvalidaException {
    try {
      boolean encontrado = false;
      for (int i = 0; i < listaDePessoas.size(); i++) {
        if (pessoa.getListaDeLivrosEmprestado().get(i) == materialBibliografico) {
          encontrado = true;
        }
      }
      if (!materialBibliografico.status() && !encontrado) {
        Emprestimo emprestimo = new Emprestimo(pessoa, materialBibliografico);
        pessoa.adicionarLivroEmprestado(materialBibliografico);
        listaDeTransacoes.add(emprestimo);
        atualizarArquivoDasTransacoes();
        atualizarArquivoDasPessoas();
        System.out.println(listaDeTransacoes);
      } else {
        throw new LivroJaEmprestadoException("livro já emprestado");
      }
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
  public void devolucao(Pessoa pessoa,MaterialBibliografico materialBibliografico) throws LivroNaoEncontradoException, TransacaoInvalidaException {
    try {
      int idEmprestimo = -1;
      for (int i = 0; i < listaDeTransacoes.size(); i++) {
        Transacao transacao = (Transacao) listaDeTransacoes.get(i);
        if (transacao instanceof Emprestimo) {
          Pessoa pessoaDaLista = transacao.getPessoa();
          MaterialBibliografico materialBibliograficoDaLista = transacao.getMaterialBibliografico();
          if (pessoaDaLista == pessoa && materialBibliograficoDaLista == materialBibliografico) {
            idEmprestimo = i;
          }
        }
      }
      if (idEmprestimo == -1) {
        throw new LivroNaoEncontradoException("livro não encontrado");
      }
        ArrayList pessoaDaListaListaDeLivros = pessoa.getListaDeLivrosEmprestado();
        pessoaDaListaListaDeLivros.remove(materialBibliografico);
        pessoa.setListaDeLivrosEmprestado(pessoaDaListaListaDeLivros);
      Transacao transacao = (Transacao) listaDeTransacoes.get(idEmprestimo);
      Devolucao devolucao = new Devolucao((Emprestimo) transacao, pessoa, materialBibliografico);
      listaDeTransacoes.add(devolucao);
      System.out.println(listaDeTransacoes);
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }

  public ArrayList getListaDeMaterialBibliografico() {
    return listaDeMaterialBibliografico;
  }

  public ArrayList getListaDeTransacoes() {
    return listaDeTransacoes;
  }

  public ArrayList getListaDePessoas() {
    return listaDePessoas;
  }

  @Override
  public String toString() {
    return "Biblioteca{" +
            "listaDeMaterialBibliografico=" + listaDeMaterialBibliografico +
            ", listaDeTransacoes=" + listaDeTransacoes +
            ", listaDePessoas=" + listaDePessoas +
            '}';
  }
}