import biblioteca.Pessoa;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    public Cliente(String nome, int idade, String CPF) {
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
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", CPF='" + CPF + '\'' +
                ", listaDeLivrosEmprestado=" + listaDeLivrosEmprestado +
                '}';
    }
}
