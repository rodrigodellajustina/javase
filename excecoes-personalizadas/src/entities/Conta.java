package entities;

import exceptions.ContaExceptions;

public class Conta {

    /*Atributos da Conta*/
    private String numero;
    private String nome;
    private double limite;
    private double saldo;

    public Conta(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
        this.limite = 0;
        this.saldo  = 0;
    }

    public String getNumero() {
        return this.numero;
    }

    public String getNome() {
        return this.nome;
    }

    public double getLimite() {
        return this.limite;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoLimite(){
        return this.saldo + this.limite;
    }

    public void sacar(double valor){
        if ((this.saldo + this.limite) >= valor){
            this.saldo = (this.saldo - valor);
        }else{
             throw new ContaExceptions("Você ultrapassando o limite e saldo, essa operação não é possível");
        }

    }


}
