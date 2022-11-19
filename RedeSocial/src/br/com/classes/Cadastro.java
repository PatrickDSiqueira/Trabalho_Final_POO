package br.com.classes;

public class Cadastro {

    private String idCadastro;
    private String nome;
    private String sobrenome;
    private String telefone;
    private String dataNascimento;
    private String sexo;
    private Usuario usuario;
    
    public Cadastro(String idCadastro, String nome, String sobrenome, String telefone, String dataNascimento,
            String sexo, Usuario usuario) {
        this.idCadastro = idCadastro;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.usuario = usuario;
    }

    public String getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(String idCadastro) {
        this.idCadastro = idCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNomeSobrenome(){
        return this.getNome() +" "+ this.getSobrenome();
    }

    @Override
    public String toString() {
        return "Cadastro [idCadastro=" + idCadastro + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone="
                + telefone + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", usuario=" + usuario.toString() + "]";
    }
    




}
