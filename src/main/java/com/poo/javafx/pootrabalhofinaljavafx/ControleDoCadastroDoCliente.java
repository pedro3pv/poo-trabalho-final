package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleDoCadastroDoCliente implements Initializable {

    @FXML
    private TextField CampoDaIdade;

    @FXML
    private TextField CampoDoCPF;

    @FXML
    private TextField CampoDoNome;
    private Biblioteca biblioteca;

    @FXML
    void cadastroDeCliente(ActionEvent event) {
        if (!CampoDoNome.getText().isEmpty() && !CampoDaIdade.getText().isEmpty() && !CampoDoCPF.getText().isEmpty()){
            biblioteca.adicionarCliente(CampoDoNome.getText(),Integer.parseInt(CampoDaIdade.getText()),CampoDoCPF.getText());
            CampoDoNome.setText("");
            CampoDaIdade.setText("");
            CampoDoCPF.setText("");
        } else {
            System.out.println("Preencha todos os campos");
        }
    }

    @FXML
    void limparCampos(ActionEvent event) {
        CampoDoNome.setText("");
        CampoDaIdade.setText("");
        CampoDoCPF.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
        HelloApplication.changeScreen("main",biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                ControleDoCadastroDoCliente.this.biblioteca = biblioteca;
            }
        });
    }
}
