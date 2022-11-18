package br.com.classes;

import java.util.ArrayList;

public class Chat {
    private ArrayList<Mensagem> mensagensEnviadas = new ArrayList<Mensagem>();
    private String usuariosParticipantes[] = new String[2];
    

    public ArrayList<Mensagem> getMensagensEnviadas() {
        return mensagensEnviadas;
    }
    public void setMensagensEnviadas(Mensagem novaMensagem) {
        this.mensagensEnviadas.add(novaMensagem);
    }
    public String[] getUsuariosParticipantes() {
        return usuariosParticipantes;
    }
    public void setUsuariosParticipantes(String[] usuariosParticipantes) {
        this.usuariosParticipantes = usuariosParticipantes;
    }


    

}
