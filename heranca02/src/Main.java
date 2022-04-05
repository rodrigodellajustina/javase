import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Main {


    public static void main(String[] args){

        Conta c = new Conta(1001, "Alex", 0.0);
        ContaCorrente cc = new ContaCorrente(1002, "Maria", 0.0, 500.0);

        // UpCasting
        Conta c2 = cc;
        Conta cc2 = new ContaCorrente(1003, "Bob", 0.0, 200.0);
        Conta cc3 = new ContaPoupanca(1004, "MARIA", 0.00, 0.04);

        //DownCasting
        ContaPoupanca cc5 = (ContaPoupanca)cc3;
        cc5.getTaxaJuro();


        //OverRide
        c.teste();
        cc2.teste();
        cc3.teste();



    }

}
