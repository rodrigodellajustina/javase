import entities.Disciplina;
import entities.Funcionario;
import entities.Professor;

import java.util.Date;

public class Main {

    public static void main(String[] args){

        Funcionario funcionario = new Funcionario("Rodrigo", "0493658754", new Date());
        System.out.println("Funcionario " + funcionario.nome);
        System.out.println("CPF " + funcionario.cpf);
        funcionario.salario = 300;
        System.out.println("Salario " + funcionario.salario);
        funcionario.qualquer();

        Professor professor = new Professor("Marcelo", "3827382737", new Date());
        System.out.println("Professor "  + professor.nome);
        System.out.println("CPF " + professor.cpf);
        Disciplina disciplina = new Disciplina("Engenharia de Software", 300, 6);
        professor.displina = disciplina;
        System.out.println("Disciplina..:" + professor.displina.getNome() + " (" + professor.displina.semestre+")");
        professor.qualquer();


    }

}
