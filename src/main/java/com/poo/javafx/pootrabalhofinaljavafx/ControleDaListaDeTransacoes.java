package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Transacao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleDaListaDeTransacoes implements Initializable {

    @FXML
    private ListView<String> listaDeTransacoes;
    private Biblioteca biblioteca;

    @FXML
    void voltarAoInicio(ActionEvent event) {
        HelloApplication.changeScreen("main",biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                ControleDaListaDeTransacoes.this.biblioteca = biblioteca;
                if (newScreen.equals("listaDeTransacoes")) {
                    ArrayList<String> temp = new ArrayList<>();
                    listaDeTransacoes.getItems().clear();
                    if (biblioteca.getListaDeTransacoes().size() > 0) {
                        for (int i = 0; i < biblioteca.getListaDeTransacoes().size(); i++) {
                            Transacao transacao = (Transacao) biblioteca.getListaDeTransacoes().get(i);
                            System.out.println(transacao);
                            ArrayList dados = transacao.dados();
                            temp.add("Tipo:"+ dados.get(4) + " Pessoa: " + dados.get(1) + " Livro: " + dados.get(2) + " Data: " + dados.get(3));
                        }
                        listaDeTransacoes.getItems().addAll(temp);
                    }
                }
            }
        });
    }
}
