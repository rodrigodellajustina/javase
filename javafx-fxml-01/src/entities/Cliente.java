package entities;

public class Cliente {

    private String nome;
    private String cidade;
    private String estado;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
