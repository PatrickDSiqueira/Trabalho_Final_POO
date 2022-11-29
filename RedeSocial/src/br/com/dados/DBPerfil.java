package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Perfil;

public class DBPerfil {
    public static ArrayList<Perfil> todosPerfis = new ArrayList<Perfil>();

    public void setTodosPerfis(Perfil perfil) {
        DBPerfil.todosPerfis.add(perfil);
    }

    public Perfil getPErfilByEmail(String email) {
        Perfil perfilEscolha = null;

        for (Perfil perfil : todosPerfis) {

            if (email.equalsIgnoreCase(perfil.getUsuario().getEmail())) {
                System.out.println(email + " testanco com esse " + perfil.getUsuario().getEmail());
                perfilEscolha = perfil;
            } else {
                System.out.println("Meu parceiro o erro esta aqui");
            }

        }

        return perfilEscolha;
    }

    public String mostrarTodosPerfil() {
        String listaPerfil = "";

        for (int i = 0; i < DBPerfil.todosPerfis.size(); i++) {
            listaPerfil += "\t" + i + " " + DBPerfil.todosPerfis.get(i).getNomeSobrenome() + "\n";
        }

        return listaPerfil;
    }

    @Override
    public String toString() {

        String listaPerfil = "";
        for (Perfil perfil : todosPerfis) {
            listaPerfil += perfil.toString() + "\n";
        }

        return "DBPerfil [" + listaPerfil + "]";
    }
}
