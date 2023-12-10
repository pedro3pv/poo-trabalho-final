package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaDeAtualizarController implements Initializable {
    @FXML
    private ChoiceBox<String> categoriaItem;

    @FXML
    private TextArea descItem;

    @FXML
    private TextField nomeItem;

    @FXML
    private TextField precoItem;
    private String[] categorias = {"eletronicos","eletrodomesticos","acessorios"};
    private ArrayList<String> retornoArvoreBinaria;
    private int iD;

    @FXML
    void atualizarItem(ActionEvent event) {

    }

    @FXML
    void cancelarAtualizacao(ActionEvent event) {

    }

    @FXML
    void excluirItem(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {

            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {

            }
        });
    }
}
