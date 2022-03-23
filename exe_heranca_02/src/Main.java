import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        ContaCorrente cc = new ContaCorrente(1002, "José", 100.0, 500.00);

        /*UpCasting  modelo01*/
        Conta conta2 = cc;
        System.out.println(conta2.getSaldo());

        /*UpCasting  modelo02*/
        Conta cc2 = new ContaCorrente(2002, "Pedro", 3000.00, 399.00);
        System.out.println(cc2.getNome());
        System.out.println(cc2.getSaldo());

        /*DownCasting*/
        ContaCorrente cc3 = (ContaCorrente) cc2;
        System.out.println(cc3.getLimite());

        ContaPoupanca ccpteste = new ContaPoupanca(3004, "Pedro da Silva", 0.00, 0.03);


    }

}
