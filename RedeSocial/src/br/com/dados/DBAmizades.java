package br.com.dados;

import java.util.ArrayList;

import br.com.classes.Amizade;
import br.com.classes.Perfil;

/**
 * DBAmizades
 */
public class DBAmizades {

    public static ArrayList<Amizade> todasAmizades = new ArrayList<Amizade>();

    public static ArrayList<Amizade> getTodasAmizades() {
        return todasAmizades;
    }

    public static ArrayList<Amizade> getTodasAmizadesbyIdPerfil(String idusuario) {

        ArrayList<Amizade> listaRetornoAmizades = new ArrayList<Amizade>();

        for (Amizade amizade : todasAmizades) {
   
            for (Perfil perfil : amizade.getPerfis()) {
                if (perfil.getIdCadastro().equals(idusuario)) {
                        listaRetornoAmizades.add(amizade);
                }
            }
            
        }
        return listaRetornoAmizades;
    }

    public static Amizade getAmizadebyIdAmizade(String idAmizade) {

        Amizade retornoAmizade = null;

        for (Amizade amizade : todasAmizades) {
   
                if (amizade.getId().equals(idAmizade)) {
                        retornoAmizade = amizade;
                }
        }
        return retornoAmizade;
    }

    public static  void setTodasAmizades(Amizade amizade) {
        DBAmizades.todasAmizades.add(amizade);
    }

    


    
}