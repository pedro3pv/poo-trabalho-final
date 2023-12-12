package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Cliente;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.MaterialBibliografico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleDaListaDeMaterialBibliografico implements Initializable {

    @FXML
    private ListView<String> listaDeMaterialBibliografico;
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
                if (newScreen.equals("listaDeMaterialBibliografico")) {
                    ArrayList<String> temp = new ArrayList<>();
                    ControleDaListaDeMaterialBibliografico.this.biblioteca = biblioteca;
                    listaDeMaterialBibliografico.getItems().clear();
                    if (biblioteca.getListaDeMaterialBibliografico().size() >0) {
                        for (int i = 0; i < biblioteca.getListaDeMaterialBibliografico().size(); i++) {
                            MaterialBibliografico materialBibliografico = (MaterialBibliografico) biblioteca.getListaDeMaterialBibliografico().get(i);
                            System.out.println(materialBibliografico);
                            ArrayList dados = materialBibliografico.dados();
                            temp.add("Tipo: " + dados.get(5) + " Titulo: " + dados.get(0) + " Paginas: " + dados.get(1) + " ISBN: " + dados.get(2) + " Autor: " + dados.get(3) + " Emprestado: " + dados.get(4));
                        }
                        listaDeMaterialBibliografico.getItems().addAll(temp);
                    }
                }
            }
        });
    }
}
