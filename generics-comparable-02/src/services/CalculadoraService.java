package services;

import entities.Produto;

import java.util.List;

public class CalculadoraService {

    public static <T extends Comparable<T>> T maiorValor(List<T> list){

        T max = list.get(0);
        for (T item : list){
            if (item.compareTo(max) > 0){
                max = item;
            }
        }

        return max;

    }


    /*Desenvolver o método para encontrar o menor valor*/

    /*Desenvolver o método para fazer a média dos produtos da lista*/



}
