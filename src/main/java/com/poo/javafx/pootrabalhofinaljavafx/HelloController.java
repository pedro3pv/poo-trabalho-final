package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> cateForm;

    @FXML
    private TextArea descForm;

    @FXML
    private TextField nomeForm;

    @FXML
    private TextField precoForm;
    private Parent root;

    private String[] categorias = {"eletronicos","eletrodomesticos","acessorios"};

    @FXML
    protected void cadastroDeProduto(ActionEvent event) {
    }

    @FXML
    protected void limparForm(ActionEvent event) {
        nomeForm.setText("");
        descForm.setText("");
        precoForm.setText("");
        System.out.println("limpou");
    }

    @FXML
    void teladois(ActionEvent event) {
        HelloApplication.changeScreen("details",new Biblioteca());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
            }
        });
        cateForm.getItems().addAll(categorias);
    }
}
