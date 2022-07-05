package entities;

public class VendaProduto {
    public Integer codigo;
    public String  descricao;
    public Integer quantidade;
    public Double  unitario;
    public Double  total;

    public String getDescricao() {
        return descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Double getTotal() {
        return total;
    }

    public Double getUnitario() {
        return unitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setUnitario(Double unitario) {
        this.unitario = unitario;
    }

    public Double calcularTotal(){
        return this.quantidade * this.unitario;
    }

}
