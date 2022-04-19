import db.SQLite;
import entities.Pessoa;

import java.util.List;

public class Main {

    public static void main(String[] args){
        try {
            SQLite dbcon = new SQLite();


            for(Pessoa people : dbcon.getAllPessoas()){
                System.out.println(people.getNome() + " | " + people.getSobrenome() + " | " + people.getIdade());
            }

            Pessoa pessoa = new Pessoa("Gilberto", "Dalla Costa", 23);
            dbcon.insertPessoa(pessoa);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
