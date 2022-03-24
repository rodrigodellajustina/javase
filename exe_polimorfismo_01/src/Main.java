import entities.Funcionario;
import entities.FuncionarioPf;
import entities.FuncionarioPj;
import entities.TipoFuncionario;

public class Main {

    public static void main(String[] args){

        /*PF = 30% */
        /*PJ = 5%  */

        Funcionario joao = new FuncionarioPf("Joao", TipoFuncionario.COORDENADOR, 500.00);
        /*Método da própria da Classe Pai /Classe Genérica (SuperClass)*/
        System.out.println(joao.getNome());
        /*Método @Override*/
        System.out.println(joao.getSalario());

        Funcionario empsistema = new FuncionarioPj("Paulo", TipoFuncionario.PROFESSOR, 300.00);
        /*Método da própria da Classe Pai /Classe Genérica (SuperClass)*/
        System.out.println(empsistema.getNome());
        /*Método @Override*/
        System.out.println(empsistema.getSalario());

        /*Não podemos instanciar objetos de classes abstract
        Funcionario func02 = new Funcionario("Paulo", TipoFuncionario.PROFESSOR, 3994.99);
        */

        /*Podemos acessar métodos static de classes abastract*/
        Funcionario.exibirTeste();

        /*Polimorfismo*/


    }

}
