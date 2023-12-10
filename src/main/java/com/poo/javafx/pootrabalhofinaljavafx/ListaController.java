package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField IDForm;

    @FXML
    private ChoiceBox<String> catFiltro;

    @FXML
    private ListView<String> listviewform;

    @FXML
    private TextField nomeForm;

    private ArrayList<String> retornoArvoreBinaria;
    private ArrayList<String> dadosLista;
    private String currentSelection;

    @FXML
    void limpar(ActionEvent event) {
        IDForm.setText("");
        nomeForm.setText("");
        catFiltro.setValue("");
        listviewform.getItems().clear();
        listviewform.getItems().addAll(dadosLista);
    }

    @FXML
    void pesquisar(ActionEvent event) {

    }

    @FXML
    void voltarAoCadastro(ActionEvent event) {

    }

    private void pesquisar(int ID,String nome,String Categoria){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listviewform.getItems().addAll(erro);
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                listviewform.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                        currentSelection = listviewform.getSelectionModel().getSelectedItem();
                    }
                });
            }
        });
    }
}
