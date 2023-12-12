package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleTransacao  implements Initializable {
    private Biblioteca biblioteca;

    @FXML
    void telaDevolucao(ActionEvent event) {
        HelloApplication.changeScreen("telaDevolucao", biblioteca);
    }
    @FXML
    void voltarAoInicio(ActionEvent event) {
        HelloApplication.changeScreen("main", biblioteca);
    }

    @FXML
    void telaEmprestimo(ActionEvent event) {
        HelloApplication.changeScreen("telaEmprestimo",biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                ControleTransacao.this.biblioteca = biblioteca;
            }
        });
    }
}
