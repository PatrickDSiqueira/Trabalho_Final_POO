package br.com.classes;

import java.util.ArrayList;

import br.com.dados.DBCadastros;

public class Usuario {

    private String id;
    private String email;
    private String senha;


    private ArrayList<Usuario> listaAmigos = new ArrayList<Usuario>();


    // private ArrayList<Solicitacao> solicitacoes = new ArrayList<Amigo>();
    // private ArrayList<Amigo> listaAmigos = new ArrayList<Amigo>();



    public void excluirAmigos( Usuario user) {

        user.getEmail();


        int indiceAmigo = listaAmigos.indexOf(user);

        listaAmigos.remove(indiceAmigo);

        System.out.println("Usuario " +  user.getEmail() + "removido");



    }

    public String verAmigos() {

        String listatoString = "";

        for (int i = 0; i < listaAmigos.size(); i++) {
            listatoString += i + 
            
        }
        return listatoString;
    }

    public ArrayList<Usuario> getListaAmigos() {
        return listaAmigos;
    }

    public void setListaAmigos(Usuario amigo) {
        this.listaAmigos.add(amigo);
    }

    public Usuario(String id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", email=" + email + ", senha=" + senha + "]";
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
}
