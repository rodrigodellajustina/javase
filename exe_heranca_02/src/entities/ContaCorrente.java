package entities;

public class ContaCorrente extends Conta {

    /*
    * Tudo que é especialista da Conta Corrente.
    * */

    private Double limite;

    public ContaCorrente(Integer numero, String nome, Double saldo, Double limite){
        super(numero, nome, saldo);
        this.limite = limite;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public void emprestimoespecial(double valor){
        if (valor <= this.limite){
            this.saldo -= (valor + 10);
        }
    }

    @Override
    public void qualeclasse(){
        System.out.println("ContaCorrente");
    }


}
