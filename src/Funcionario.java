import biblioteca.Pessoa;

import java.util.ArrayList;

public class Funcionario extends Pessoa {
    public Funcionario(String nome, int idade, String CPF) {
        super(nome, idade, CPF);
    }
    @Override
    public String toString() {
        return "Funcionario" +
                ", "+nome +
                ", " + idade +
                ", " + CPF ;
    }

    @Override
    public ArrayList dados(){
        ArrayList dados = new ArrayList<>();
        dados.add(nome);
        dados.add(idade);
        dados.add(CPF);
        return dados;
    }
}
