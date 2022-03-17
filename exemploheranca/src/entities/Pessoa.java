package entities;
import java.util.Date;

public class Pessoa {

    public String nome;
    public String cpf;
    public Date data_nacimento;

    public Pessoa(String nome, String cpf, Date dtnascimento){
        this.nome = nome;
        this.cpf  = cpf;
        this.data_nacimento = dtnascimento;
    }

    public void qualquer(){
        System.out.println("Foi Chamado");
    }

}
