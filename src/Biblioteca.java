import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

import java.nio.file.Path;
import java.util.ArrayList;

public class Biblioteca {
  private ArrayList listaDeMaterialBibliografico;
  private ArrayList listaDeTransacoes;
  private ArrayList listaDePessoas;

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

  private void adicionarMaterialBibliografico(MaterialBibliografico materialBibliografico){
    boolean contains = false;
    for (int i = 0;i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico obj = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (String.valueOf(materialBibliografico).equals(String.valueOf(obj))){
        contains = true;
      }
    }
    if (!contains){
      listaDeMaterialBibliografico.add(materialBibliografico);
    } else {
      System.out.println("livro já está na lista");
    }
    atualizarArquivoDoMaterialBibliografico();
  }

  public void adicionarLivro(String titulo, int numeroDePaginas, int iSBN, String autor){
    Livro livro = new Livro(titulo,numeroDePaginas,iSBN,autor);
    adicionarMaterialBibliografico(livro);
  }

  public void adicionarRevista(String titulo, int numeroDePaginas, int iSBN, String autor){
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

  public void removerMaterialBibliografico(int iSBN){
    for (int i = 0; i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico materialBibliografico = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (iSBN == materialBibliografico.getISBN()){
        listaDeMaterialBibliografico.remove(materialBibliografico);
      }
    }
    atualizarArquivoDoMaterialBibliografico();
  }
  public void emprestimo(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    Emprestimo emprestimo = new Emprestimo(pessoa,materialBibliografico);
    listaDeTransacoes.add(emprestimo);
    atualizarArquivoDasTransacoes();
  }
  public void devolucao(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    int idEmprestimo = 0;
    for (int i = 0; i < listaDeTransacoes.size();i++){
      Transacao transacao = (Transacao) listaDeTransacoes.get(i);
      if (transacao instanceof Emprestimo){
        Pessoa pessoaDaLista = transacao.getPessoa();
        MaterialBibliografico materialBibliograficoDaLista = transacao.getMaterialBibliografico();
        if (pessoaDaLista == pessoa && materialBibliograficoDaLista == materialBibliografico){
          idEmprestimo = i;
        }
      }
    }
    Transacao transacao = (Transacao) listaDeTransacoes.get(idEmprestimo);
    Devolucao devolucao = new Devolucao((Emprestimo) transacao,pessoa,materialBibliografico);
    listaDeTransacoes.add(devolucao);
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