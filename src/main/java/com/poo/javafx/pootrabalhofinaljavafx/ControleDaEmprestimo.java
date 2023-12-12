package com.poo.javafx.pootrabalhofinaljavafx;

import com.poo.javafx.pootrabalhofinaljavafx.livraria.Biblioteca;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.LivroJaEmprestadoException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.Excecoes.TransacaoInvalidaException;
import com.poo.javafx.pootrabalhofinaljavafx.livraria.biblioteca.Pessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControleDaEmprestimo implements Initializable {
    @FXML
    private Text ISBN;

    @FXML
    private Button botaoCadastro;

    @FXML
    private ChoiceBox<String> cliente;

    @FXML
    private TextField iSBNform;

    @FXML
    private Button limparbotao;
    private Biblioteca biblioteca;

    @FXML
    void cadastroDeDevolucao(ActionEvent event) throws TransacaoInvalidaException, LivroJaEmprestadoException {
        Pessoa pessoa = null;
        Pessoa pessoa2 = null;
        ArrayList arrayList = biblioteca.getListaDePessoas();
        for (int i = 0; i < biblioteca.getListaDePessoas().size(); i++) {
            pessoa = (Pessoa) arrayList.get(i);
            if (cliente.getValue().equals(pessoa.getNome())) {
                pessoa2 = (Pessoa) arrayList.get(i);
            }
        }
        biblioteca.emprestimo(pessoa2, Integer.parseInt(iSBNform.getText()));
        iSBNform.setText("");
    }

    @FXML
    void limparForm(ActionEvent event) {
        iSBNform.setText("");
    }

    @FXML
    void voltar(ActionEvent event) {
        HelloApplication.changeScreen("telaTransacao", biblioteca);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HelloApplication.addOnChangeScreenListener(new HelloApplication.OnChangeScreen() {
            @Override
            public void OnChangeScreen(String newScreen, Biblioteca biblioteca) {
                if (newScreen.equals("telaEmprestimo")) {
                    ControleDaEmprestimo.this.biblioteca = biblioteca;
                    ArrayList listaDePessoas = biblioteca.getListaDePessoas();
                    cliente.getItems().clear();
                    for (int i = 0; i < listaDePessoas.size(); i++) {
                        Pessoa pessoa = (Pessoa) listaDePessoas.get(i);
                        cliente.getItems().add(pessoa.getNome());
                    }
                }
            }
        });
    }
}