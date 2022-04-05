package entities;

public class ContaPoupanca extends Conta {

    private Double taxajuro;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(Integer numero, String pessoa, Double saldo, Double taxajuro) {
        super(numero, pessoa, saldo);
        this.taxajuro = taxajuro;
    }

    public Double getTaxaJuro() {
        return this.taxajuro;
    }

    public void setTaxaJuro(Double taxa) {
        this.taxajuro = taxa;
    }

    public void atualizasaldo() {
        this.saldo += this.saldo * this.taxajuro;
    }
}
