import entities.Produto;
import services.CalculadoraService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Produto> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("c:\\temp\\produtos.txt"))){
            String line = br.readLine();

            /*
             Faz leitura do arquivo produtos.txt linha a linha e adiciona na lista (list)
             */
            while(line != null){
                String[] campos = line.split(",");
                //System.out.println(line);
                list.add(new Produto(campos[0], Double.parseDouble(campos[1]), campos[2]));
                line = br.readLine();
            }
            /*
            * Apresentando os valores armazenados na lista (list)
            * */
            System.out.println("Lista de Produtos");
            for(Produto prd : list){
                System.out.println(prd.getNome() + "|" + prd.getPreco() + "|" + prd.getTipo());
            }

            Produto maiorValor = CalculadoraService.maiorValor(list);
            System.out.println("");
            System.out.println("");
            System.out.println("Produto de maior valor ");
            System.out.println(maiorValor.getNome() + "|" + maiorValor.getPreco() + "|" + maiorValor.getTipo());


            /*Chamada para inclusão de novos produtos*/

        }catch (IOException e){
            System.out.println("Entrou no Catch");
            System.out.println(e.getMessage());
        }

    }
}
