package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleDaTelaInicial implements Initializable {

    private Biblioteca biblioteca;

    @FXML
    void cadastroDeCliente(ActionEvent event) {
        HelloApplication.changeScreen("cadastroDeCliente",biblioteca);
    }


    @FXML
    void cadastroDeMaterialBibliografico(ActionEvent event) {
        HelloApplication.changeScreen("cadastroDeMaterialBibliografico",biblioteca);
    }

    @FXML
    void listaDeClientes(ActionEvent event) {
        HelloApplication.changeScreen("listaDeClientes",biblioteca);
    }

    @FXML
    void listaDeMaterialBibliografico(ActionEvent event) {
        HelloApplication.changeScreen("listaDeMaterialBibliografico",biblioteca);
    }

    @FXML
    void listaDeTransacoes(ActionEvent event) {
        HelloApplication.changeScreen("listaDeTransacoes",biblioteca);
    }

    @FXML
    void transacoes(ActionEvent event) {
        HelloApplication.changeScreen("telaTransacao",biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                ControleDaTelaInicial.this.biblioteca = biblioteca;
            }
        });
    }
}
