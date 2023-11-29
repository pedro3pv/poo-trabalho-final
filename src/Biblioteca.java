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
          ArrayList tempArray = new ArrayList();
          for(int i = 0;i<tempArraylist.size();i++){
            String stemp = tempArraylist.get(i);
            List temps = Arrays.asList(stemp.split(", "));
            tempArray.add(temps);
          }
          listaDeTransacoes = new ArrayList(tempArray);
          //System.out.println(listaDeTransacoes);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void adicionarMaterialBibliografico(MaterialBibliografico materialBibliografico){
    try {
      listaDeMaterialBibliografico.add(materialBibliografico);
      if (Files.readString(pathMaterialBibliografico) != "") {
        String listaTemp = Files.readString(pathMaterialBibliografico) + "-" + String.valueOf(materialBibliografico);
        Files.writeString(pathMaterialBibliografico,listaTemp);
      }else {
        Files.writeString(pathMaterialBibliografico, String.valueOf(materialBibliografico));
      }
      System.out.println("arquivo alterado com sucesso");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void adicionarLivro(String titulo, int numeroDePaginas, int iSBN, String autor){
    Livro livro = new Livro(titulo,numeroDePaginas,iSBN,autor);
    adicionarMaterialBibliografico(livro);
  }

  public void adicionarRevista(String titulo, int numeroDePaginas, int iSBN, String autor){
    Revista revista = new Revista(titulo,numeroDePaginas,iSBN,autor);
    listaDeMaterialBibliografico.add(revista);
  }

  public void removerMaterialBibliografico(int iSBN){
    for (int i = 0; i < listaDeMaterialBibliografico.size();i++){
      MaterialBibliografico materialBibliografico = (MaterialBibliografico) listaDeMaterialBibliografico.get(i);
      if (iSBN == materialBibliografico.getISBN()){
        listaDeMaterialBibliografico.remove(materialBibliografico);
      }
    }
  }
  public void emprestimo(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    Emprestimo emprestimo = new Emprestimo(listaDeTransacoes.size(),pessoa,materialBibliografico);
    listaDeTransacoes.add(emprestimo);
  }
  public void devolucao(Pessoa pessoa,MaterialBibliografico materialBibliografico){
    Devolucao devolucao = new Devolucao(listaDeTransacoes.size(),pessoa,materialBibliografico);
    listaDeTransacoes.add(devolucao);
  }
}