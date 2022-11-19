import java.util.Random;
import java.util.Scanner;

import br.com.classes.Cadastro;
import br.com.classes.Perfil;
import br.com.classes.Usuario;
import br.com.dados.DBAmizades;
import br.com.dados.DBCadastros;
import br.com.dados.DBPerfil;
import br.com.dados.DBUsuarios;

/**
 * App
 */
public class App {

    static DBCadastros dbCadastros = new DBCadastros();
    static DBUsuarios dbUsuarios = new DBUsuarios();
    static DBPerfil dbPerfis = new DBPerfil();
    static Scanner ler = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Perfil perfilLogado = null;

    public static void main(String[] args) {

        setarUsuariosTeste();

        String opcao = "";

        do {
            System.out.println("Digite uma opção\n 1-criar conta\n 2- Logar\n 0- Encerrar Programa \n --> ");
            opcao = ler.nextLine();

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
                    System.out.println("opcao invalida");
                    break;
            }

        } while (!opcao.equals("0"));

    }

    private static void setarUsuariosTeste() {

        String idUsuario = Integer.toString(aleatorio.nextInt(100));
        Usuario usuario = new Usuario(idUsuario, "teste@gmail.com", "123");

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

    private static void logar() {

        System.out.print("email : ");
        String email = ler.nextLine();

        System.out.println("senha : ");
        String senha = ler.nextLine();

        if (dbUsuarios.checkEmailCadastrado(email)) {

            if (senha.equals(dbUsuarios.getUsuariobyEmail(email).getSenha())) {

                perfilLogado = dbPerfis.getPErfilByEmail(email);
                System.out.println("usuario logado");
                programaLogado();
            } else {
                System.out.println("Senha errada");
            }

        } else {
            System.out.println("Email não cadastrado");
        }

    }

    private static void programaLogado() {
        String opcao = "";
        String menu = "1 - incluir amigos \n 2 - consultar amigos \n 3 Excluir amigos \n 0 - logout \n -> ";

        do {
            System.out.println(menu);
            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    criarAmizade();

                    break;
                case "2":
                    // consultar Amigos
                    System.out.println(perfilLogado.consultaAmigos());

                    break;
                // Paulo refatora esse case  !!!
                // case "3":
                //     System.out.println(perfilLogado.consultaAmigos());
                //     System.out.println("Qual amigo vc deseja excluir");
                //     int indexAmigo = ler.nextInt();
                //     if (indexAmigo <= DBAmizades.getTodasAmizadesbyId(perfilLogado.getIdCadastro()).size()) {
                //         perfilLogado.excluirAmigos(
                //                 dbUsuarios.getUsuariobyID(perfilLogado.getListaAmigos().get(indexAmigo).getId()));
                //     } else {
                //         System.out.println("opcao invalida");
                //     }

                //     break;

                case "0":
                    perfilLogado = null;
                    System.out.println("logout realizado");
                    break;

                default:
                    System.out.println("opcao invalida");
                    break;
            }

        } while (!opcao.equals("0"));
    }

    private static void criarAmizade() {
        String opcao = "";
        do {
            System.out.println(
                    "1 - ver todos os usuarios disponiveis \n 2 - Digitar email do amigo \n 0 - voltar ao menu alterior \n ->");
            opcao = ler.nextLine();

            switch (opcao) {

                case "1":

                    System.out.println(dbPerfis.mostrarTodosPerfil());
                    System.out.println("digite a opcao para adicionar ");
                    int escolha = ler.nextInt();

                    perfilLogado.criarAmizade(DBPerfil.todosPerfis.get(escolha), perfilLogado);

                    System.out.println("Amigo cadastrado");

                    break;
                case "2":
                    System.out.println("Escreva o email do usuario");
                    String email = ler.nextLine();

                    if (dbUsuarios.checkEmailCadastrado(email)) {
                        Usuario user = dbUsuarios.getUsuariobyEmail(email);
                        perfilLogado.setListaAmigos(user);
                        System.out.println("Amigo cadastrado");
                    } else {
                        System.out.println("Usuario nao encontrado");
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

        System.out.println("Digite o seu nome : ");
        // String nome = ler.nextLine();
        String nome = "Patrick";

        System.out.println("Digite o seu Sobrenome : ");
        // String sobrenome = ler.nextLine();
        String sobrenome = "Dias";

        System.out.println("Digite o seu telefone : ");
        // String telefone = ler.nextLine();
        String telefone = "31984305054";

        System.out.println("Digite o seu dataNascimento : ");
        // String dataNascimento = ler.nextLine();
        String dataNascimento = "09/07/2001";

        System.out.println("Digite o seu sexo : ");
        // String sexo = ler.nextLine();
        String sexo = "Masculino";

        Usuario usuario = criarUsuario();

        Cadastro cadastro = new Cadastro(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, usuario);

        dbCadastros.setTodosCadastro(cadastro);

        dbUsuarios.setTodosUsuarios(usuario);

        System.out.println("Cadastro realizado");

    }

    private static Usuario criarUsuario() {

        Usuario usuario = null;

        String email;

        do {

            System.out.println("Digite o seu email : ");
            email = ler.nextLine();

        } while (dbUsuarios.checkEmailCadastrado(email));

        System.out.println("Digite o sua senha : ");
        // String senha = ler.nextLine();
        String senha = "123456";

        String idUsuario = Integer.toString(aleatorio.nextInt(100));
        usuario = new Usuario(idUsuario, email, senha);

        return usuario;
    }
}