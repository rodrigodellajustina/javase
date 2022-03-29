import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        metodo01();
    }

    public static void metodo01(){
        System.out.println("Inicio :: metodo01");
        metodo02();
        System.out.println("Fim :: metodo01");
    }

    public static void metodo02(){
        System.out.println("Inicio :: metodo02");
        Scanner sc = new Scanner(System.in);

        try {
            String[] vect = sc.nextLine().split(" ");
            int position = sc.nextInt();
            System.out.println(vect[position]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Posição do Array não existe");
            e.printStackTrace();
        }finally {
            sc.close();
        }


        System.out.println("Fim :: metodo02");


    }



}
