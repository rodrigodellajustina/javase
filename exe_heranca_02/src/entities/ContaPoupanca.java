package entities;

public class ContaPoupanca extends Conta{

    /*
    * Tudo que é especialista da Conta Poupança
    * */

    public Double taxajuros;

    public ContaPoupanca(Integer numero, String nome, Double saldo, Double taxajuros) {
        super(numero, nome, saldo);
        this.taxajuros = taxajuros;
    }

    public Double getTaxajuros() {
        return taxajuros;
    }

    public void setTaxajuros(Double taxajuros) {
        this.taxajuros = taxajuros;
    }

    public void atualizasaldo(){
        this.saldo += this.saldo * this.taxajuros;

    }

    @Override
    public void qualeclasse(){
        System.out.println("ContaPoupanca");
    }



}
