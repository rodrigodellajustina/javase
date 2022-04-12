package entities;
import java.util.ArrayList;
import java.util.List;

public class Servicos<Generic> {

    private List<Generic> list = new ArrayList<>();

    public void addValor(Generic valor){
        list.add(valor);
    }

    public Generic primeiroElemento(){
        return list.get(0);
    }

}