import entities.Conta;

public class Main {

    public static void main(String[] args){

        Conta conta = new Conta("3972-3", "Joao");
        conta.setSaldo(300);
        conta.setLimite(3000);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getLimite());
        System.out.println(conta.getSaldoLimite());

        conta.sacar(5000.00);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getSaldo()+conta.getLimite());

    }


}
