package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Cadastro;

public class DBCadastros {

    private ArrayList<Cadastro> todosCadastro = new ArrayList<Cadastro>();

    public ArrayList<Cadastro> getTodosCadastro() {
        return todosCadastro;
    }

    public void mostrarTodosCadastros() {
        for (Cadastro user : getTodosCadastro()) {
            System.out.println(user.toString());
        }
    }

    public void setTodosCadastro(Cadastro cadastro) {
        this.todosCadastro.add(cadastro);
    }

    public Cadastro getCadastrobyFKUsuario(String idUsuario){

        Cadastro cad = null;
        
    return cad;

}

    @Override
    public String toString() {
        String listaCadastros = "";
        for (Cadastro cadastro : todosCadastro) {
            listaCadastros += cadastro.toString() + "\n";
        }
        return "DBCadastros [todosCadastro= "+listaCadastros+"]";
    }

}
