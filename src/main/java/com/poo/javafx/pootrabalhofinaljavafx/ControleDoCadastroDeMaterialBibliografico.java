package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TituloInvalidoException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.livroExistenteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControleDoCadastroDeMaterialBibliografico implements Initializable {

    @FXML
    private TextField iSBNform;

    @FXML
    private TextField autor;

    @FXML
    private Button botaoCadastro;

    @FXML
    private Button limparbotao;

    @FXML
    private TextField numPag;

    @FXML
    private ChoiceBox<String> tipoMaterialBibliografico;

    @FXML
    private TextField titulo;
    private Biblioteca biblioteca;
    private String[] tipo = {"Livro","Revista"};

    @FXML
    void cadastroDeProduto(ActionEvent event) throws livroExistenteException, TituloInvalidoException {
        if (tipoMaterialBibliografico.getValue() == "Livro") {
            if (!iSBNform.getText().isEmpty() && !autor.getText().isEmpty() && !numPag.getText().isEmpty() && !titulo.getText().isEmpty()) {
                biblioteca.adicionarLivro(titulo.getText(), Integer.parseInt(numPag.getText()), Integer.parseInt(iSBNform.getText()), autor.getText());
                iSBNform.setText("");
                autor.setText("");
                numPag.setText("");
                titulo.setText("");
            }
        } else if (tipoMaterialBibliografico.getValue() == "Revista"){
            if (!iSBNform.getText().isEmpty() && !autor.getText().isEmpty() && !numPag.getText().isEmpty() && !titulo.getText().isEmpty()) {
                biblioteca.adicionarRevista(titulo.getText(), Integer.parseInt(numPag.getText()), Integer.parseInt(iSBNform.getText()), autor.getText());
                iSBNform.setText("");
                autor.setText("");
                numPag.setText("");
                titulo.setText("");
            }
        } else {
            System.out.println("Preencha todos os campos");
        }
    }

    @FXML
    void limparForm(ActionEvent event) {
        iSBNform.setText("");
        autor.setText("");
        numPag.setText("");
        titulo.setText("");
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
                ControleDoCadastroDeMaterialBibliografico.this.biblioteca = biblioteca;
            }
        });
        tipoMaterialBibliografico.setItems(javafx.collections.FXCollections.observableArrayList(tipo));
    }
}
