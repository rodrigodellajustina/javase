package entities;

public class Produto implements Comparable<Produto>{

    private String nome;
    private Double preco;
    private String tipo;

    public Produto(String nome, Double preco, String tipo){
        this.nome  = nome;
        this.preco = preco;
        this.tipo  = tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public Double getPreco() {
        return this.preco;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /*Desenvolver um método para inserir os produtos no arquivo c:\temp\produtos.txt*/

    @Override
    public int compareTo(Produto outros) {
        return preco.compareTo(outros.getPreco());
    }

}
