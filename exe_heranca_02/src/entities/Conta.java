package entities;

public class Conta {

    /*
    * Tudo que é Genérico entre CONTAS: ContaCorrente e Conta Poupança
    * */

    private Integer numero;
    private String nome;
    public Double saldo;

    public Conta(Integer numero, String nome, Double saldo){
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void sacar(double valor){
        this.saldo -= valor;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void qualeclasse(){
        System.out.println("Conta");
    }



}
