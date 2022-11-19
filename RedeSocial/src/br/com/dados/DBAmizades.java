package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Amizade;
import br.com.classes.Perfil;

/**
 * DBAmizades
 */
public class DBAmizades {

    public static ArrayList<Amizade> todasAmizades = new ArrayList<Amizade>();

    public static ArrayList<Amizade> getTodasAmizadesbyId(String idusuario) {
        ArrayList<Amizade> listaRetornoAmizades = new ArrayList<Amizade>();

        for (Amizade amizade : todasAmizades) {
   
            for (Perfil perfil : amizade.getPerfis()) {
                if (perfil.getIdCadastro().equals(idusuario)) {
                        listaRetornoAmizades.add(amizade);
                }
            }
            
        }
        return todasAmizades;
    }

    public static  void setTodasAmizades(Amizade todosPerfis) {
        DBAmizades.todasAmizades.add(todosPerfis);
    }

    


    
}