package entities;

import java.util.Date;

public class Professor extends Pessoa {
    public Professor(String nome, String cpf, Date dtnascimento) {
        super(nome, cpf, dtnascimento);
    }
    public Disciplina displina;
}
