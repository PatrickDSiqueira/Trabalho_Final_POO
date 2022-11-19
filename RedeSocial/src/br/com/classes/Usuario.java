package br.com.classes;

public class Usuario {

    private String id;
    private String email;
    private String senha;

    public Usuario(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
    }
}
