package services;

import enums.Estado;

public interface Pessoas {
    /*
    * Assinaturas do métodos
    * */
    /*GET*/
    public String getNome();
    public String getIdentificacao();
    public String getCidade();
    public Estado getEstado();

    /*SET*/
    public void setNome(String nome);
    public void setIdentificacao(String identificacao);
    public void setCidade(String cidade);
    public void setEstado(Estado estado);


}
