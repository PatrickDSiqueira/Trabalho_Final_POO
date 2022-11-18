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
        
for (int i = 0; i < getTodosCadastro().size(); i++) {
    if (idUsuario.equals(getTodosCadastro().get(i).getFKusuario())) {
        cad= getTodosCadastro().get(i);
    }
    
}
            
        

    return cad;

}

}
