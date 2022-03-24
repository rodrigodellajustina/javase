package entities;

public abstract class Funcionario {

    private String nome;
    private TipoFuncionario tipofuncionario;
    private Double salario;

    public Funcionario(String nome, TipoFuncionario tpfuncionario, Double salario){
        this.nome = nome;
        this.tipofuncionario = tpfuncionario;
        this.salario = salario;
    }

    public Double getSalario() {
        return this.salario;
    }

    public String getNome() {
        return this.nome;
    }

    public TipoFuncionario getTipofuncionario() {
        return tipofuncionario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipofuncionario(TipoFuncionario tipofuncionario) {
        this.tipofuncionario = tipofuncionario;
    }

    public static void exibirTeste(){
        System.out.println("teste");
    }

}
