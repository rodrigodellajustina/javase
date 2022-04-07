package entities;

import java.util.Date;

public class Contrato {

    private Integer numero;
    private Date dtcriacao;
    private Date dtvencimento;
    private Pessoa pessoa;

    public Integer getNumero() {
        return this.numero;
    }

    public Date getDtcriacao() {
        return this.dtcriacao;
    }

    public Date getDtvencimento() {
        return this.dtvencimento;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDtcriacao(Date dtcriacao) {
        this.dtcriacao = dtcriacao;
    }

    public void setDtvencimento(Date dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
