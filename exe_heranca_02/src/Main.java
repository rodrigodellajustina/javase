import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Main {

    public static void main(String[] args){
        /*Conta Corrente*/
        ContaCorrente cc = new ContaCorrente(3333, "Rodrigo", 100.00, 10.00);
        /*Implementado na Classe Pai/Generalista*/
        System.out.println(cc.getSaldo());
        System.out.println(cc.getNome());
        System.out.println(cc.getNumero());


        /*Implementação na Classe Filha/Especialista*/
        System.out.println(cc.getLimite());
        cc.setLimite(12.00);
        System.out.println(cc.getLimite());
        cc.qualeclasse();

        ContaPoupanca cp = new ContaPoupanca(3884, "Marcelo", 300.00, 0.01);
        cp.qualeclasse();






    }

}
