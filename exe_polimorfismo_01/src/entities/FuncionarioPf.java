package entities;

public class FuncionarioPf extends Funcionario{
    public FuncionarioPf(String nome, TipoFuncionario tpfuncionario, Double salario) {
        super(nome, tpfuncionario, salario);
    }

    @Override
    public Double getSalario() {
        return super.getSalario() - (super.getSalario() * 0.30);
    }
}
