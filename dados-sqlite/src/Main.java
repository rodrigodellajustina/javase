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
            prd1.setDescricao("Fanta Laranja 300 ml");
            prd1.setCodbarra("7876238172");
            prd1.setPreco(6.21);
            dbcon.insertProduto(prd1);

            if (dbcon.checkProduto(prd1)){
                System.out.println("Esse Produto Já existe");
            }else{
                System.out.println("Esse Produto NÃO existe");
            }

            /*Atualizando Preço*/
            System.out.println("Atualizando Preço do Produto");
            Produto prdUpd = new Produto();
            prdUpd.setDescricao("Coca-Cola Lata 350 ml");
            prdUpd.setCodbarra("87578457872");
            prdUpd.setPreco(2.50);
            dbcon.insertProduto(prdUpd);

            /*Listando Produtos*/
            /*
            System.out.println("Listando Produtos");
            for(Produto produto : dbcon.getAllProdutos("")){
                System.out.println(produto.getCodbarra() + " | " + produto.getDescricao() + " | R$ " + produto.getPreco());
            }
            */



            //dbcon.deleteProduto(prdUpd);

            /*Listando Após a Eliminação*/
            /*
            System.out.println("Listando Produtos após delete");
            for(Produto produto : dbcon.getAllProdutos("")){
                System.out.println(produto.getCodbarra() + " | " + produto.getDescricao() + " | R$ " + produto.getPreco());
            }
            */


            /*Listando COM FILTRO*/
            System.out.println("Listando Produtos");
            for(Produto produto : dbcon.getAllProdutos("2 litros")){
                System.out.println(produto.getCodbarra() + " | " + produto.getDescricao() + " | R$ " + produto.getPreco());
            }

            Produto prdCopia = new Produto();
            prdCopia.setCodbarra("78485485235");
            prdCopia.setDescricao("Coca-Cola 2 Litros");
            prdCopia.setPreco(13.5);

            dbcon.copiaProduto(prdCopia, "79485485235");







        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
