package br.com.classes;

import java.util.ArrayList;

public class Amizade {
    private String id;
    private Perfil[] perfis = new Perfil[2];
    private ArrayList<Mensagem> chat = new ArrayList<Mensagem>();

    public Amizade(String id, Perfil[] perfis, ArrayList<Mensagem> chat) {
        this.id = id;
        this.perfis = perfis;
        this.chat = chat;
    }

    public Amizade() {
    }

    public Perfil buscarAmigo(String idUsuarioLogado) {
        Perfil perfilBusca = null;

        for (Perfil perfil : perfis) {
            if (!(perfil.getIdCadastro().equals(idUsuarioLogado))){
                perfilBusca = perfil;
            };
            
        }

        return perfilBusca;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Perfil[] getPerfis() {
        return perfis;
    }

    public void setPerfis(Perfil perfil1, Perfil perfil2) {
        this.perfis[0] = perfil1;
        this.perfis[1] = perfil2;
    }

    public ArrayList<Mensagem> getChat() {
        return chat;
    }

    public void setChat(ArrayList<Mensagem> chat) {
        this.chat = chat;
    }

}
