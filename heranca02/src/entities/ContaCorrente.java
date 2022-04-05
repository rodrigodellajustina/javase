package entities;

public class ContaCorrente extends Conta {

    private Double limiteEmprestimo;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(Integer numero, String nome, Double saldo, Double limite) {
        super(numero, nome, saldo);
        this.limiteEmprestimo = limite;
    }

    public Double getLimiteEmprestimo() {
        return this.limiteEmprestimo;
    }

    public void setLimiteEmprestimo(Double limite) {
        this.limiteEmprestimo = limite;
    }

    public void emprestimo(double valor) {
        if (valor <= this.limiteEmprestimo) {
            saldo -= (valor + 10.0);
        }
    }

    @Override
    public void teste(){
        System.out.println("teste 2");
    }

}
