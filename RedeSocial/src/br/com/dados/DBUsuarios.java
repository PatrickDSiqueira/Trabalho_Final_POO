package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Usuario;

public class DBUsuarios {

    public ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();

    public int size(){
        return todosUsuarios.size();
    }

    public ArrayList<Usuario> getTodosUsuarios() {
        return todosUsuarios;
    }

    public Usuario getUsuariobyEmail(String email) {

        ArrayList<Usuario> listaUsuarios = getTodosUsuarios();

        Usuario user = null;

        for (int i = 0; i < listaUsuarios.size(); i++) {

            if (listaUsuarios.get(i).getEmail().equalsIgnoreCase(email)) {

                user = listaUsuarios.get(i);

            }
        }

        return user;
    }

    public Usuario getUsuariobyID(String id) {

        ArrayList<Usuario> listaUsuarios = getTodosUsuarios();

        Usuario user = null;

        for (int i = 0; i < listaUsuarios.size(); i++) {

            if (listaUsuarios.get(i).getId().equals(id)) {

                user = listaUsuarios.get(i);

            }
        }

        return user;
    }

    public boolean checkEmailCadastrado(String email) {

        boolean temCadastro = false;

        for (int i = 0; i < this.getTodosUsuarios().size(); i++) {

            if (getTodosUsuarios().get(i).getEmail().equalsIgnoreCase(email)) {

            temCadastro = true;
            System.out.println("Email já cadastrado");

            }
        }
        return temCadastro;

    }

    public void mostrarTodosUsuarios(){
        for (Usuario user : getTodosUsuarios()) {
            System.out.println(user.toString());
        } 
    }

    public void setTodosUsuarios(Usuario usuario) {
        this.todosUsuarios.add(usuario);
    }

    @Override
    public String toString() {

        String listaUsuario = "";
        for (Usuario usuario : todosUsuarios) {
            listaUsuario += usuario.toString() + "\n";
        }


        return "DBUsuarios [todosUsuarios=" + listaUsuario + "]";
    }

}
