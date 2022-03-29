import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = null;
        File arquivo = new File("C:\\temp\\arquivo.txt");
        try {
            sc = new Scanner(arquivo);
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch (IOException e){
            System.out.println("O arquivo não foi encontrado " + arquivo.getAbsoluteFile());
        }finally {
            if (sc != null){
                sc.close();
            }
        }

    }


}

