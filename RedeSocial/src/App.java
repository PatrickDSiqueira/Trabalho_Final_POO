import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;

import br.com.classes.Amizade;
import br.com.classes.Cadastro;
import br.com.classes.Perfil;
import br.com.classes.Usuario;
import br.com.dados.DBAmizades;
import br.com.dados.DBCadastros;
import br.com.dados.DBPerfil;
import br.com.dados.DBUsuarios;
import br.com.limpaConsole.Limpa;

// App.

public class App {

    static DBCadastros dbCadastros = new DBCadastros();
    static DBUsuarios dbUsuarios = new DBUsuarios();
    static DBPerfil dbPerfis = new DBPerfil();
    static Scanner ler = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Perfil perfilLogado = null;

    public static void main(String[] args) throws InterruptedException, IOException {

        setarUsuariosTeste();

        String opcao = "";

        do {
            System.out.println(
                    "\n\nDigite uma opção que deseja realizar:\n\n 1 - Criar conta\n 2 - Logar\n 0 - Encerrar Programa \n --> ");
            opcao = ler.nextLine();
            ler = new Scanner(System.in);
            Limpa.Console();

            switch (opcao) {
                case "1":
                    criarCadastro();

                    break;
                case "2":
                    logar();
                    break;

                case "0":
                    System.out.println("Programa encerrando....");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (!opcao.equals("0"));

    }

    private static void setarUsuariosTeste() {

        String idUsuario = Integer.toString(aleatorio.nextInt(100));
        Usuario usuario = new Usuario(idUsuario, "m", "123");

        Cadastro cadastro = new Cadastro(Integer.toString(aleatorio.nextInt(100)),
                "joao",
                "Marcelo",
                "190",
                "08/07/2001",
                "Masculino",
                usuario);
        Perfil perfil = new Perfil(cadastro);

        dbPerfis.setTodosPerfis(perfil);
        dbCadastros.setTodosCadastro(cadastro);
        dbUsuarios.setTodosUsuarios(usuario);

        idUsuario = Integer.toString(aleatorio.nextInt(100));
        usuario = new Usuario(idUsuario, "teste@gmail.com", "123");

        cadastro = new Cadastro(Integer.toString(aleatorio.nextInt(100)),
                "Paulo",
                "Marcelo",
                "190",
                "08/07/2001",
                "Masculino",
                usuario);
        perfil = new Perfil(cadastro);

        dbPerfis.setTodosPerfis(perfil);
        dbCadastros.setTodosCadastro(cadastro);
        dbUsuarios.setTodosUsuarios(usuario);

        idUsuario = Integer.toString(aleatorio.nextInt(100));
        usuario = new Usuario(idUsuario, "teste@gmail.com", "123");

        cadastro = new Cadastro(Integer.toString(aleatorio.nextInt(100)),
                "Marlon",
                "Marcelo",
                "190",
                "08/07/2001",
                "Masculino",
                usuario);
        perfil = new Perfil(cadastro);

        dbPerfis.setTodosPerfis(perfil);
        dbCadastros.setTodosCadastro(cadastro);
        dbUsuarios.setTodosUsuarios(usuario);
    }

    private static void logar() throws InterruptedException, IOException {

        System.out.print("\nEmail : \n");
        String email = ler.nextLine();
        ler = new Scanner(System.in);

        System.out.println("\nSenha : ");
        String senha = ler.nextLine();
        ler = new Scanner(System.in);

        if (senha.equals(dbUsuarios.getUsuariobyEmail(email).getSenha())) {

            perfilLogado = dbPerfis.getPErfilByEmail(email);
            System.out.println("\nUsuário logado \n");
            programaLogado();
        } else {
            System.out.println("Senha incorreta.");
        }
    }

    private static void programaLogado() throws InterruptedException, IOException {
        String opcao = "";
        String menu = " 1 - Visualizar todos os usuários \n 2 - Consultar meus amigos \n 3 - Excluir amigos \n 4 - Chat \n 0 - Logout. \n --> ";

        do {
            System.out.println(menu);
            opcao = ler.nextLine();
            ler = new Scanner(System.in);
            Limpa.Console();

            switch (opcao) {
                case "1":
                    criarAmizade();

                    break;
                case "2":

                    System.out.println(perfilLogado.mostrarTodosAmigos());

                    break;

                case "3":
                    System.out.println(perfilLogado.mostrarTodosAmigos());
                    System.out.println("Qual amigo vc deseja excluir \n --> ");
                    int indexAmigo = ler.nextInt();
                    ler = new Scanner(System.in);

                    if (indexAmigo <= DBAmizades.getTodasAmizadesbyIdPerfil(perfilLogado.getIdCadastro()).size()) {
                        perfilLogado.desfazerAmizade(perfilLogado.getListaIdAmizades().get(indexAmigo));
                    } else {
                        System.out.println("Opção invalida.");
                    }

                    break;

                case "4":

                    System.out
                            .println("Em qual chat deseja entrar ? (Obs.: envie em msg '0' para sair do chat) \n -->");

                    System.out.println(perfilLogado.mostrarTodosAmigos());

                    int index = ler.nextInt();
                    ler = new Scanner(System.in);
                    Amizade amizadeSelecionada = DBAmizades.getTodasAmizadesbyIdPerfil(perfilLogado.getIdCadastro())
                            .get(index);
                    String msg = "";
                    
                    do {
                        Limpa.Console();

                        for (int i = 0; i < amizadeSelecionada.getChat().size(); i++) {
                            System.out.println(amizadeSelecionada.getChat().get(i));

                        }

                        System.out.print("msg --> ");
                        msg = ler.nextLine();
                        ler = new Scanner(System.in);

                        if (!msg.equals("0")) {
                            amizadeSelecionada.enviarMensagem(msg, perfilLogado);

                        }

                    } while ((!msg.equals("0")));

                    break;

                case "0":
                    perfilLogado = null;
                    System.out.println("Logout realizado.");
                    break;

                default:
                    System.out.println("Opção invalida.");
                    break;
            }

        } while (!opcao.equals("0"));
    }

    private static void criarAmizade() {
        String opcao = "";
        do {
            System.out.println(
                    "\n 1 - Visualizar todos os usuarios disponíveis \n 2 - Digitar email do amigo \n 0 - voltar ao menu anterior \n -->");
            opcao = ler.nextLine();
            ler = new Scanner(System.in);

            switch (opcao) {

                case "1":

                    System.out.println(dbPerfis.mostrarTodosPerfil());
                    System.out.println("Digite a opção para adicionar para adicionar o amigo: ");
                    int escolha = ler.nextInt();
                    ler = new Scanner(System.in);

                    perfilLogado.criarAmizade(DBPerfil.todosPerfis.get(escolha), perfilLogado);

                    System.out.println("Amigo adicionado.");

                    break;
                case "2":
                    System.out.println("Escreva o email do usuário");
                    String email = ler.nextLine();
                    ler = new Scanner(System.in);

                    if (dbUsuarios.checkEmailCadastrado(email)) {
                        Perfil perfil = dbPerfis.getPErfilByEmail(email);
                        perfilLogado.criarAmizade(perfil, perfilLogado);
                        System.out.println("Amigo cadastrado.");
                    } else {
                        System.out.println("Usuário nao encontrado.");
                    }

                    break;
                case "":

                    break;

                default:
                    break;
            }

        } while (!opcao.equals("0"));

    }

    private static void criarCadastro() {

        String idCadastro = Integer.toString(aleatorio.nextInt(100));

        System.out.println("\nDigite o seu nome : ");
        String nome = ler.nextLine();
        ler = new Scanner(System.in);

        System.out.println("\nDigite o seu Sobrenome : ");
        String sobrenome = ler.nextLine();

        System.out.println("\nDigite o seu telefone : ");
        String telefone = ler.nextLine();

        System.out.println("\nDigite a sua data de nascimento : ");
        String dataNascimento = ler.nextLine();

        System.out.println("\nDigite o seu sexo : ");
        String sexo = ler.nextLine();

        Usuario usuario = criarUsuario();

        Cadastro cadastro = new Cadastro(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);

        dbPerfis.setTodosPerfis(new Perfil(cadastro));
        dbCadastros.setTodosCadastro(cadastro);
        dbUsuarios.setTodosUsuarios(usuario);

        System.out.println("\nCadastro realizado com sucesso.");

    }

    private static Usuario criarUsuario() {

        Usuario usuario = null;

        String email;

        do {

            System.out.println("\nDigite o seu email : ");
            email = ler.nextLine();

        } while (dbUsuarios.checkEmailCadastrado(email));

        System.out.println("\nDigite o sua senha : ");
        String senha = ler.nextLine();

        String idUsuario = Integer.toString(aleatorio.nextInt(100));
        usuario = new Usuario(idUsuario, email, senha);

        return usuario;
    }

}