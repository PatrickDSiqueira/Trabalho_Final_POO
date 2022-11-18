package br.com.classes;
public class Cadastro {

    private String idCadastro;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String dataNascimento;
    private String sexo;
    private String FKusuario;

    public String getFKusuario() {
        return FKusuario;
    }


    public Cadastro(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento,
            String sexo, String FKusuario) {
        this.idCadastro = idCadastro;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.FKusuario = FKusuario;
    }


    public void setIdCadastro(String idCadastro) {
        this.idCadastro = idCadastro;
    }

    public String getUsuario() {
        return FKusuario;
    }

    public void setUsuario(String FKusuario) {
        this.FKusuario = FKusuario;
    }

    public String getId() {
        return idCadastro;
    }
    
    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

}
