package br.com.classes;

import java.util.ArrayList;
import java.util.Date;

public class Amizade {
    private String id;
    private Perfil[] perfis = new Perfil[2];
    private ArrayList<Mensagem> chat = new ArrayList<Mensagem>();

    public Amizade(String id, Perfil[] perfis) {
        this.id = id;
        this.perfis = perfis;
        this.chat = new ArrayList<Mensagem>();
    }

    public Amizade() {
        this.chat = new ArrayList<Mensagem>();
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



    public void enviarMensagem(String conteudo, Perfil autor ) {
        Mensagem msg = new Mensagem(conteudo, new Date(), autor);
        getChat().add(msg);
    }

}
