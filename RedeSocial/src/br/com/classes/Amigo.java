package br.com.classes;
import java.util.ArrayList;
import java.util.Date;

public class Amigo {
    private String id;
    private Usuario usuario;
    private Usuario Amigousuario;
    private Date dataAmizade;
    private ArrayList<Mensagem> chat = new ArrayList<Mensagem>();
    
    @Override
    public String toString() {
        return "Amigo [id=" + id + "]";
    }    


    
}
