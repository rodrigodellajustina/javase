package entities;

public class Usuario2 {
    private String nome;
    private String email;

    public Usuario2(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) { this.email = email; }
}
