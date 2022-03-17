package entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Pessoa {


    // Atributo
    private String nome;
    private int idade;
    private double altura;
    private String telefone;

    // Construtor
    public Pessoa(String nome, int idade, double altura, String telefone){
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.telefone = telefone;
    }

    public String getNome() {
        return this.nome;
    }

    public static List<Pessoa> busca(List<Pessoa> pessoas, String busca){
        List<Pessoa> pessoasSelecionadas2 = pessoas.stream().filter(p ->p.getNome().contains(busca)).collect(Collectors.toList());
        return pessoasSelecionadas2;
    }

}
