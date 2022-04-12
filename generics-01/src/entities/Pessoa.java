package entities;

public class Pessoa {

    private String nome;
    private String cidade;

    public String getCidade() {
        return this.cidade;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
