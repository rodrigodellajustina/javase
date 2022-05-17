package entitites;

public class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preco){
        this.nome = nome;
        this.preco = preco;
    }

    public Produto(String nome, String preco){
        this.nome = nome;
        this.preco = Double.parseDouble(preco);
    }


}
