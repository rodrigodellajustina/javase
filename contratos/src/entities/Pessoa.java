package entities;

import enums.Estado;
import services.Pessoas;

public abstract class Pessoa implements Pessoas {
    private String cidade;
    private Estado estado;

    @Override
    public String getCidade() {
        return this.cidade;
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }

    @Override
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
