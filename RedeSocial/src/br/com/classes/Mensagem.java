package br.com.classes;
import java.util.Date;

public class Mensagem {
    
    private String conteudo;
    private Date dataHoraEnvio;
    private String autor;
    private String destinatatio;

    public Mensagem(String conteudo, Date dataHoraEnvio, String autor) {
        this.conteudo = conteudo;
        this.dataHoraEnvio = dataHoraEnvio;
        this.autor = autor;
    }
}
