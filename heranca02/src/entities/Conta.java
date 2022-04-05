package entities;

public class Conta {

    private Integer numero;
    private String nome;
    protected Double saldo;

    public Conta() {
    }

    public Conta(Integer numero, String nome, Double saldo) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void saque(double valor) {
        this.saldo -= valor;
    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public void teste(){
        System.out.println("Teste");
    }

}
