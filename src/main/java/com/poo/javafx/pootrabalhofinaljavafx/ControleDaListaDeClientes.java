package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleDaListaDeClientes implements Initializable {
    private Biblioteca biblioteca;

    @FXML
    private ListView<String> listaDeClientes;

    @FXML
    void voltarAoInicio(ActionEvent event) {
        HelloApplication.changeScreen("main",biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                if (newScreen.equals("listaDeClientes")) {
                    ArrayList<String> temp = new ArrayList<>();
                    ControleDaListaDeClientes.this.biblioteca = biblioteca;
                    listaDeClientes.getItems().clear();
                    if (biblioteca.getListaDePessoas().size() >0) {
                        for (int i = 0; i < biblioteca.getListaDePessoas().size(); i++) {
                            Cliente cliente = (Cliente) biblioteca.getListaDePessoas().get(i);
                            System.out.println(cliente);
                            ArrayList dados = cliente.dados();
                            temp.add("Nome: " + dados.get(0) + " Idade: " + dados.get(1) + " CPF: " + dados.get(2));
                        }
                        listaDeClientes.getItems().addAll(temp);
                    }
                }
            }
        });
    }
}
