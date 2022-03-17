package entities;

import java.util.Date;

public class Funcionario extends Pessoa {
    public Funcionario(String nome, String cpf, Date dtnascimento) {
        super(nome, cpf, dtnascimento);
    }
    public double salario;
    public Date data_admissao;
    public String cargo;


}
