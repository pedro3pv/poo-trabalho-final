import Excecoes.IdadeInvalidaException;
import biblioteca.Pessoa;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    public Funcionario(String nome, int idade, String CPF) throws IdadeInvalidaException {
        super(nome, idade, CPF);
    }

    @Override
    public ArrayList dados(){
        ArrayList dados = new ArrayList<>();
        dados.add(nome);
        dados.add(idade);
        dados.add(CPF);
        return dados;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", CPF='" + CPF + '\'' +
                ", listaDeLivrosEmprestado=" + listaDeLivrosEmprestado +
                '}';
    }
}
