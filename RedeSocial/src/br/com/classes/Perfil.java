package br.com.classes;

import java.util.ArrayList;
import java.util.Random;

import br.com.dados.DBAmizades;

public class Perfil extends Cadastro {

    private String biografia;
    private String statusRelacionamento;
    // private ArrayList<Amizade> listaAmizades = new ArrayList<Amizade>();
    public int perfil2;

    public Perfil(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento, String sexo,
            Usuario usuario) {
        super(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);
        // TODO Auto-generated constructor stub
    }

    public Perfil(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento, String sexo,
            Usuario usuario, String biografia, String statusRelacionamento) {
        super(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);
        this.biografia = biografia;
        this.statusRelacionamento = statusRelacionamento;
        // this.listaAmizades = listaAmizades;
    }

    public Perfil(Cadastro cadastro) {
        super(cadastro.getIdCadastro(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getTelefone(), cadastro.getDataNascimento(), cadastro.getSexo(), cadastro.getUsuario());
    }


    public String consultaAmigos(){
        String listaAmigos ="";

        
        // for (int i = 0; i < this.listaAmizades.size(); i++) {
            
            //     listaAmigos += i + this.listaAmizades.get(i).buscarAmigo(super.getIdCadastro()).getNome();
            // }
            ArrayList<Amizade> listAmigos =  DBAmizades.getTodasAmizadesbyId(super.getIdCadastro());
        for (int i = 0; i < listAmigos.size(); i++) {
            listaAmigos += i + listAmigos.get(i).buscarAmigo(super.getIdCadastro()).getNome();
        }

        return listaAmigos;
    }

    public void criarAmizade(Perfil perfilAmigo, Perfil logado) {
        Random aleatorio = new Random();

        Amizade amizade = new Amizade();
        amizade.setId(Integer.toString(aleatorio.nextInt(100)));
        amizade.setPerfis(perfilAmigo, logado);

        DBAmizades.setTodasAmizades(amizade);






    }
}