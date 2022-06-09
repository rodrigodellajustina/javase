package entities;

public class Produto {

    private Integer codigo;
    private String descricao;
    private Double custo;
    private Double preco;

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao.toUpperCase();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    public Double getCusto() {
        return this.custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


}
