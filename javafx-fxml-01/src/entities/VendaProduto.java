package entities;

public class VendaProduto {
    public Integer  codigo;
    public String   descricao;
    public Integer  quantidade;
    public Double   unitario;
    public Double   total;

    public void setCodigo(Integer codigoProduto) {
        this.codigo = codigoProduto;
    }

    public void setDescricao(String descricaoProduto) {
        this.descricao = descricaoProduto;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setUnitario(double unitario) {
        this.unitario = unitario;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public double getUnitario() {
        return unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double calcularTotal(){
        return this.quantidade * this.unitario;
    }
}

