package entities;

public class FuncionarioPj extends Funcionario{
    public FuncionarioPj(String nome, TipoFuncionario tpfuncionario, Double salario) {
        super(nome, tpfuncionario, salario);
    }

    @Override
    public Double getSalario() {
        return super.getSalario() - (super.getSalario() * 0.05);
    }
}
