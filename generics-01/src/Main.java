import entities.Pessoa;
import entities.Servicos;

public class Main {

    public static void main(String[] args){

        /*String*/
        Servicos<String> servicos = new Servicos();
        servicos.addValor("Marcelo");
        servicos.addValor("Tiago");
        servicos.addValor("Rodrigo");
        servicos.addValor("Mateus");

        String a = servicos.primeiroElemento();
        System.out.println(a);

        /*Inteiro*/
        Servicos<Integer> servicos1 = new Servicos<>();
        servicos1.addValor(30);
        servicos1.addValor(50);

        Integer b = servicos1.primeiroElemento();
        System.out.println(b);

        /*Pessoa*/
        Servicos<Pessoa> service2 = new Servicos<>();
        Pessoa pe1 = new Pessoa();
        pe1.setNome("Rodrigo");
        pe1.setCidade("Curitiba");
        service2.addValor(pe1);

        Pessoa c = service2.primeiroElemento();
        System.out.println(c.getNome());





    }

}
