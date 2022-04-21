package entities;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private String cpf;

    public Pessoa(String nome, String sobrenome, int idade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade     = idade;
    }

    public Pessoa(String nome, String sobrenome, int idade, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf   = cpf;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
