package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Perfil;

public class DBPerfil {
    public static ArrayList<Perfil> todosPerfis = new ArrayList<Perfil>();

    public void setTodosPerfis(Perfil perfil) {
        DBPerfil.todosPerfis.add(perfil);
    }

    public Perfil getPErfilByEmail(String email){
        Perfil perfilEscolha = null;

        for (Perfil perfil : todosPerfis) {
            if (email.equals(perfil.getUsuario().getEmail())) {
                perfilEscolha = perfil;
            }
            
        }

        DBPerfil.todosPerfis.get(1).getUsuario().getEmail();


        return perfilEscolha;
    }
    
    public String mostrarTodosPerfil(){
        String listaPerfil = "";

        for (int i = 0; i < DBPerfil.todosPerfis.size(); i++) {
            listaPerfil += i +" "+ DBPerfil.todosPerfis.get(i).getNomeSobrenome();
        }

        return listaPerfil;
    }    
}
