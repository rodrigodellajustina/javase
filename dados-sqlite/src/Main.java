import db.SQLite;
import entities.Pessoa;
import entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try {
            SQLite dbcon = new SQLite();
            /*

            PESSOA:

            System.out.println("Inserindo Pessoas na tabela");
            dbcon.insertPessoa(new Pessoa("Rodrigo", "Della Justina", 39, "4838828228284"));
            dbcon.insertPessoa(new Pessoa("Matheus", "Assis Vieira", 19,  "8127381298232"));
            dbcon.insertPessoa(new Pessoa("Diogo", "Borges Kompier", 23,  "9872381778728"));
            dbcon.insertPessoa(new Pessoa("Tiago", "Delfino da Silva", 39,"4838828228282"));
            dbcon.insertPessoa(new Pessoa("Marcelo", "Di Kaprio", 23,"9812391827282"));

            for(Pessoa people : dbcon.getAllPessoas()){
                System.out.println(people.getNome() + " | " + people.getSobrenome() + " | " + people.getIdade());
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Atualizando Tiago..");
            Pessoa pessoaupd = new Pessoa("Tiago", "da Silva", 25, "4838828228282");
            dbcon.updatePessoa(pessoaupd);


            for(Pessoa people : dbcon.getAllPessoas()){
                System.out.println(people.getNome() + " | " + people.getSobrenome() + " | " + people.getIdade());
            }

            System.out.println("");
            System.out.println("");
            System.out.println("Eliminado o Marcelo..");
            Pessoa pessoadelete = new Pessoa("", "", 23, "9812391827282");
            dbcon.eliminarPessoa(pessoadelete);

            for(Pessoa people : dbcon.getAllPessoas()){
                System.out.println(people.getNome() + " | " + people.getSobrenome() + " | " + people.getIdade());
            }

             */

            //PRODUTO

            Produto prd1 = new Produto();
            prd1.setDescricao("Coca-Cola Lata 299 ml");
            prd1.setCodbarra("72387827382");
            prd1.setPreco(4.21);
            //System.out.println(prd1.getDescricao());

            if (dbcon.checkProduto(prd1)){
                System.out.println("Esse Produto Já existe");
            }else{
                System.out.println("Esse Produto NÃO existe");
            }

            dbcon.insertProduto(prd1);
            //dbcon.insertProdutoCheck(prd1);







        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
