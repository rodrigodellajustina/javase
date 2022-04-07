import entities.Contrato;
import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;
import enums.Estado;

public class Main {

    public static void main(String[] args){

        Fisica pessoafisica = new Fisica();
        pessoafisica.setNome("Marcelo");
        pessoafisica.setIdentificacao("398726347687");
        pessoafisica.setCidade("Rio de Janeiro");
        pessoafisica.setEstado(Estado.RJ);

        //System.out.println(pessoafisica.getNome());
        //System.out.println(pessoafisica.getCidade());

        Juridica pessoajuridica = new Juridica();
        pessoajuridica.setNome("EMPRES X LTDA");
        pessoajuridica.setIdentificacao("45464500144");
        pessoajuridica.setCidade("Cascavel");
        pessoajuridica.setEstado(Estado.PR);

        //System.out.println(pessoajuridica.getNome());
        //System.out.println(pessoajuridica.getCidade());

        Contrato alguelcasa = new Contrato();
        alguelcasa.setNumero(393126371);
        alguelcasa.setPessoa(pessoafisica);
        System.out.println(alguelcasa.getNumero());
        System.out.println(alguelcasa.getPessoa().getCidade());
        System.out.println(alguelcasa.getPessoa().getNome());



    }

}
