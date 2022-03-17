package entities;

public class Disciplina {

    public String nome;
    public int duracao;
    public int semestre;

    public Disciplina(String nome, int duracao, int semestre){
        this.nome = nome;
        this.duracao = duracao;
        this.semestre = semestre;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getSemestre() {
        return this.semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}
