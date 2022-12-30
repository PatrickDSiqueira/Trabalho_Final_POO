package br.com.classes;
import java.util.Date;

public class Mensagem {
    
    private String conteudo;
    private Date dataHoraEnvio;
    private Perfil autor;
    private StatusMEnsagem Status;

    public StatusMEnsagem getStatus() {
        return Status;
    }

    public void setStatus(StatusMEnsagem status) {
        Status = status;
    }

    public Perfil getAutor() {
        return autor;
    }

    public void setAutor(Perfil autor) {
        this.autor = autor;
    }

    public Mensagem(String conteudo, Date dataHoraEnvio, Perfil autor) {
        this.conteudo = conteudo;
        this.dataHoraEnvio = dataHoraEnvio;
        this.autor = autor;
        this.Status =  StatusMEnsagem.Enviado;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(Date dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }
    
    @Override
    public String toString() {
        return " - - -  [ "+autor.getNome()+" ] " + conteudo + "\n\t" + dataHoraEnvio + "\n\t" + Status + "\n\t";
    }

    public void checkVisualizacao() {
        this.Status = StatusMEnsagem.Visto;
    }
}
