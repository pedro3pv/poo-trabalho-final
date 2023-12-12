package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static Stage stage;
    private static Scene mainScreen;
    private static Scene listaScreenDeClientes;
    private static Scene listaScreenDeTransacoes;
    private static Scene listaScreenDeMaterialBibliografico;
    private static Scene cadastroDeCliente;
    private static Scene cadastroDeMaterialBibliografico;
    private static Scene telaTransacao;
    private static Scene telaDevolucao;
    private static Scene telaEmprestimo;
    private static Biblioteca biblioteca = new Biblioteca();
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlMain = new FXMLLoader(HelloApplication.class.getResource("TelaInicial.fxml"));
        FXMLLoader fxmlListaDeClientes = new FXMLLoader(HelloApplication.class.getResource("Tela_LIstadeClientes.fxml"));
        FXMLLoader fxmlListaDeTransacoes = new FXMLLoader(HelloApplication.class.getResource("Tela_ListadeTransacoes.fxml"));
        FXMLLoader fxmlListaDeMaterialBibliografico = new FXMLLoader(HelloApplication.class.getResource("Tela_ListadeMaterialBibliografico.fxml"));
        FXMLLoader fxmlCadastroDeCliente = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeCliente.fxml"));
        FXMLLoader fxmlCadastroDeMaterialBibliografico = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeMaterialBibliografico.fxml"));
        FXMLLoader fxmlTelaTransacao = new FXMLLoader(HelloApplication.class.getResource("TelaTransacao.fxml"));
        FXMLLoader fxmlTelaDevolucao = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeDevolucao.fxml"));
        FXMLLoader fxmlTelaEmprestimo = new FXMLLoader(HelloApplication.class.getResource("TelaCadastroDeEmprestimo.fxml"));
        mainScreen = new Scene(fxmlMain.load(), 983, 700);
        listaScreenDeClientes = new Scene(fxmlListaDeClientes.load(),983,700);
        listaScreenDeTransacoes = new Scene(fxmlListaDeTransacoes.load(),983,700);
        listaScreenDeMaterialBibliografico = new Scene(fxmlListaDeMaterialBibliografico.load(),983,700);
        cadastroDeCliente = new Scene(fxmlCadastroDeCliente.load(),983,700);
        cadastroDeMaterialBibliografico = new Scene(fxmlCadastroDeMaterialBibliografico.load(),983,700);
        telaTransacao = new Scene(fxmlTelaTransacao.load(),983,700);
        telaDevolucao = new Scene(fxmlTelaDevolucao.load(),983,700);
        telaEmprestimo = new Scene(fxmlTelaEmprestimo.load(),983,700);
        primaryStage.setTitle("Poo");
        primaryStage.setScene(mainScreen);
        notifyAllListeners("main",biblioteca);
        stage = primaryStage;
        primaryStage.show();
    }

    public static void changeScreen(String scr, Biblioteca biblioteca){
        switch (scr){
            case "main":
                stage.setScene(mainScreen);
                notifyAllListeners("main",biblioteca);
                break;
case "listaDeClientes":
                stage.setScene(listaScreenDeClientes);
                notifyAllListeners("listaDeClientes",biblioteca);
                break;
case "listaDeTransacoes":
                stage.setScene(listaScreenDeTransacoes);
                notifyAllListeners("listaDeTransacoes",biblioteca);
                break;
case "listaDeMaterialBibliografico":
                stage.setScene(listaScreenDeMaterialBibliografico);
                notifyAllListeners("listaDeMaterialBibliografico",biblioteca);
                break;
case "cadastroDeCliente":
                stage.setScene(cadastroDeCliente);
                notifyAllListeners("cadastroDeCliente",biblioteca);
                break;
case "cadastroDeMaterialBibliografico":
                stage.setScene(cadastroDeMaterialBibliografico);
                notifyAllListeners("cadastroDeMaterialBibliografico",biblioteca);
                break;
case "telaTransacao":
                stage.setScene(telaTransacao);
                notifyAllListeners("telaTransacao",biblioteca);
                break;
case "telaDevolucao":
                stage.setScene(telaDevolucao);
                notifyAllListeners("telaDevolucao",biblioteca);
                break;
case "telaEmprestimo":
                stage.setScene(telaEmprestimo);
                notifyAllListeners("telaEmprestimo",biblioteca);
                break;
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    public static interface OnChangeScreen{
        void OnChangeScreen(String newScreen, Biblioteca biblioteca);
    }
    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    private static void notifyAllListeners(String newScreen, Biblioteca biblioteca){
        for (OnChangeScreen l : listeners){
            l.OnChangeScreen(newScreen,biblioteca);
        }
    }
}