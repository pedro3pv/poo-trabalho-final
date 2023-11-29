import biblioteca.MaterialBibliografico;
import biblioteca.Pessoa;
import biblioteca.Transacao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {
  private ArrayList listaDeMaterialBibliografico = new ArrayList<MaterialBibliografico>();
  private ArrayList listaDeTransacoes = new ArrayList<Transacao>();
  private Path pathMaterialBibliografico = Path.of("./MaterialBibliografico.txt");
  Path pathTransacoes = Path.of("./Transacoes.txt");

  public Biblioteca() {
    try {
      if (Files.notExists(pathMaterialBibliografico)) {
        Files.createFile(pathMaterialBibliografico);
      }
      if (Files.notExists(pathTransacoes)) {
        Files.createFile(pathTransacoes);
      }
      if (Files.exists(pathMaterialBibliografico)) {
        String s = Files.readString(pathMaterialBibliografico);
        if (s != "") {
          List tempLoad = Arrays.asList(s.split("-"));
          ArrayList<String> tempArraylist = new ArrayList(tempLoad);
          for(int i = 0;i<tempArraylist.size();i++){
            String stemp = tempArraylist.get(i);
            List temps = Arrays.asList(stemp.split(", "));
            System.out.println(temps.get(0));
            if (temps.get(0).equals("Livro")){
              Livro livro = new Livro(temps.get(1).toString(), Integer.parseInt(temps.get(2).toString()), Integer.parseInt(temps.get(3).toString()), temps.get(4).toString());
              listaDeMaterialBibliografico.add(livro);
            }
            if (temps.get(0).equals("Revista")){
              Revista revista = new Revista(temps.get(1).toString(), Integer.parseInt(temps.get(2).toString()), Integer.parseInt(temps.get(3).toString()), temps.get(4).toString());
              listaDeMaterialBibliografico.add(revista);
            }
          }
          System.out.println(listaDeMaterialBibliografico);
        }
      }
      if (Files.exists(pathTransacoes)) {
        String s = Files.readString(pathTransacoes);
        if (s != "") {
          List tempLoad = Arrays.asList(s.split("-"));
          ArrayList<String> tempArraylist = new ArrayList(tempLoad);
          for(int i = 0;i<tempArraylist.size();i++){
            String stemp = tempArraylist.get(i);
            List temps = Arrays.asList(stemp.split(", "));
            System.out.println(temps.get(0));
            if (temps.get(0).equals("Emprestimo")){
              Emprestimo emprestimo = new Emprestimo((Pessoa) temps.get(0), (MaterialBibliografico) temps.get(1));
              listaDeTransacoes.add(emprestimo);
            }
            if (temps.get(0).equals("Devolucao")){
              Devolucao devolucao = new Devolucao((Pessoa) temps.get(0), (MaterialBibliografico) temps.get(1));
              listaDeTransacoes.add(devolucao);
            }
          }
          System.out.println(listaDeTransacoes);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void atualizarArquivoDoMaterialBibliografico(){
    try {
      String listaTemp = "";
      for (int i = 0;i < listaDeMaterialBibliografico.size();i++){
        if (listaTemp != "") {
          listaTemp = listaTemp + "-" + String.valueOf(listaDeMaterialBibliografico.get(i));
        }else {
          listaTemp = String.valueOf(listaDeMaterialBibliografico.get(i));
        }
      }
      Files.writeString(pathMaterialBibliografico,listaTemp);
      System.out.println("arquivo alterado com sucesso");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void atualizarArquivoDasTransacoes(){
    try {
      String listaTemp = "";
      for (int i = 0;i < listaDeTransacoes.size();i++){
        if (listaTemp != "") {
          listaTemp = listaTemp + "-" + String.valueOf(listaDeTransacoes.get(i));
        }else {
          listaTemp = String.valueOf(listaDeTransacoes.get(i));
        }
      }
      Files.writeString(pathTransacoes,listaTemp);
      System.out.println("arquivo alterado com sucesso");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
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

  public void removerMaterialBibliografico(int iSBN){
    for (int i = 0; i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico materialBibliografico = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (iSBN == materialBibliografico.getISBN()){
        listaDeMaterialBibliografico.remove(materialBibliografico);
      }
    }
    atualizarArquivoDoMaterialBibliografico();
  }
  /*public void emprestimo(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    Emprestimo emprestimo = new Emprestimo(listaDeTransacoes.size(),pessoa,materialBibliografico);
    listaDeTransacoes.add(emprestimo);
  }
  public void devolucao(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    Devolucao devolucao = new Devolucao(listaDeTransacoes.size(),pessoa,materialBibliografico);
    listaDeTransacoes.add(devolucao);
  }*/
}