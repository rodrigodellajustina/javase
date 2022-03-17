import entities.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        List<Pessoa> pessoas = new ArrayList<>();

        Pessoa pessoa1 = new Pessoa("Pedro da Silva", 18, 1.84, "2184474444");
        Pessoa pessoa2 = new Pessoa("Paulo da Silveira", 18, 1.73, "2184474444");
        Pessoa pessoa3 = new Pessoa("Mateus de Oliveira", 18, 1.84, "2184474444");
        Pessoa pessoa4 = new Pessoa("Mauricio Siqueira", 18, 1.84, "2184474444");
        Pessoa pessoa5 = new Pessoa("Pedro Siqueira", 18, 1.84, "2184474444");

        //inclusão
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);
        pessoas.add(pessoa5);

        System.out.println("Listanto Total..:");
        for(Pessoa pessoa : pessoas){
            System.out.println("Nome " + pessoa.getNome());
        }

        pessoas.remove(pessoa2);

        System.out.println("Listanto após a remoção");
        for(Pessoa pessoa : pessoas){
            System.out.println("Nome " + pessoa.getNome());
        }

        System.out.println("Informe predicado da Busca");
        Scanner teclado = new Scanner(System.in);
        String predicado = teclado.nextLine();


        System.out.println("Buscando por " + predicado);
        for(Pessoa busca : Pessoa.busca(pessoas, predicado)){
            System.out.println(busca.getNome());
        }



    }
}
