package entities;

public class Estado {
    private Integer id;
    private Integer codigoUf;
    private String nome;
    private String uf;
    private Integer regiao;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigoUf() {
        return this.codigoUf;
    }

    public void setCodigoUf(Integer codigoUf) {
        this.codigoUf = codigoUf;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Integer getRegiao() {
        return this.regiao;
    }

    public void setRegiao(Integer regiao) {
        this.regiao = regiao;
    }
}
