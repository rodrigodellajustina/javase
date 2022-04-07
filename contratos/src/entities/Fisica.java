package entities;

public class Fisica extends Pessoa{

    private String nome;
    private String cpf;

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public String getIdentificacao() {
        return this.cpf;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setIdentificacao(String identificacao) {
        this.cpf = identificacao;
    }
}
