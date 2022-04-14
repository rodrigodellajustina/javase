import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        List<Integer> listint = Arrays.asList(1,2,3,4);
        System.out.println("Lista Origem listint");
        System.out.println(listint);

        List<Object> listobjects = new ArrayList<Object>();
        copiar(listint, listobjects);
        System.out.println("Lista Destino copiada listint");
        System.out.println(listobjects);

        /*Double*/
        listobjects.clear();
        List<Double> listdouble = Arrays.asList(3.33, 4.33, 5.44, 9.44);
        System.out.println(listdouble);
        copiar(listdouble, listobjects);
        System.out.println(listobjects);


    }

    /*Objetivo é copiar os dados de uma lista inteira
    * para uma lista do tipo objeto, que é definida a partir de ?
    *  */
    public static void copiar(List<? extends Number> origem, List<? super Number> destino){
        for(Number number : origem){
            destino.add(number);
        }
    }


}
