package br.com.classes;

import java.util.ArrayList;
import java.util.Random;

import br.com.dados.DBAmizades;

public class Perfil extends Cadastro {

    public String id;
    private String biografia;
    private String statusRelacionamento;
    private ArrayList<String> listaIdAmizades = new ArrayList<String>();

    public ArrayList<String> getListaIdAmizades() {
        return listaIdAmizades;
    }

    public void setListaIdAmizades(String IdAmizade) {
        this.listaIdAmizades.add(IdAmizade);
    }

    public Perfil(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento, String sexo,
            Usuario usuario, String id, String biografia, String statusRelacionamento) {
        super(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);
        this.id = super.getIdCadastro();
        this.biografia = biografia;
        this.statusRelacionamento = statusRelacionamento;
    }

    public Perfil(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento, String sexo,
            Usuario usuario) {
        super(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);
        this.id = super.getIdCadastro();
    }

    public Perfil(Cadastro cadastro) {
        super(cadastro.getIdCadastro(), cadastro.getNome(), cadastro.getSobrenome(), cadastro.getTelefone(),
                cadastro.getDataNascimento(), cadastro.getSexo(), cadastro.getUsuario());
        this.id = super.getIdCadastro();
    }

    public String mostrarTodosAmigos() {

        String listaTodosAmigos = "";

        ArrayList<Amizade> listAmigos = DBAmizades.getTodasAmizadesbyIdPerfil(super.getIdCadastro());
        for (int i = 0; i < listAmigos.size(); i++) {
            listaTodosAmigos += "\t" + i + " - "
                    + listAmigos.get(i).buscarAmigo(super.getIdCadastro()).getNomeSobrenome() + "\n";
        }

        return listaTodosAmigos;
    }

    public void criarAmizade(Perfil perfilAmigo, Perfil logado) {
        Random aleatorio = new Random();

        Amizade amizade = new Amizade();
        amizade.setId(Integer.toString(aleatorio.nextInt(100)));
        amizade.setPerfis(perfilAmigo, logado);

        DBAmizades.setTodasAmizades(amizade);

        perfilAmigo.setListaIdAmizades(amizade.getId());
        this.setListaIdAmizades(amizade.getId());
    }

    @Override
    public String toString() {
        return "Perfil [id=" + id + ", biografia=" + biografia + ", statusRelacionamento=" + statusRelacionamento
                + ", listaIdAmizades=" + listaIdAmizades + "]";
    }

    public void desfazerAmizade(String idAmizade){

        // remover do perfil 
        Amizade amizade = DBAmizades.getAmizadebyIdAmizade(idAmizade);
        
        for (Perfil perfil : amizade.getPerfis()) {
                perfil.listaIdAmizades.remove(idAmizade);
        }

        // remover do Array
        DBAmizades.todasAmizades.remove(DBAmizades.getAmizadebyIdAmizade(idAmizade));

        // alerta
        System.out.println("feito");
    }
}