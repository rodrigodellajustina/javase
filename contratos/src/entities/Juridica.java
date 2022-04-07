package entities;

public class Juridica extends Pessoa{

    private String razaosocial;
    private String cnpj;


    @Override
    public String getNome() {
        return this.razaosocial;
    }

    @Override
    public String getIdentificacao() {
        return this.cnpj;
    }

    @Override
    public void setNome(String nome) {
        this.razaosocial = nome;
    }

    @Override
    public void setIdentificacao(String identificacao) {
        this.cnpj = identificacao;
    }
}
