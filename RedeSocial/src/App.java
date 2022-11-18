import java.util.Random;
import java.util.Scanner;

import br.com.classes.Cadastro;
import br.com.classes.Usuario;
import br.com.dados.DBCadastros;
import br.com.dados.DBUsuarios;

/**
 * App
 */
public class App {

    static DBCadastros dbCadastros = new DBCadastros();
    static DBUsuarios dbUsuarios = new DBUsuarios();
    static Scanner ler = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Usuario usuarioLogado = null; 

    public static void main(String[] args) {

        String opcao = "";

        do {
            System.out.println("Digite uma opção\n 1-criar conta\n 2- Logar\n 3- Encerrar Programa \n --> ");
            opcao = ler.nextLine();

            switch (opcao) {
                case "1":
                    criarCadastro();

                    break;
                case "2":
                    logar();

                    break;

                default:
                    break;
            }

        } while (!opcao.equals("0"));

    }

    private static void logar() {

        System.out.print("email : ");
        String email = ler.nextLine();

        System.out.println("senha : ");
        String senha = ler.nextLine();


        if (dbUsuarios.checkEmailCadastrado(email)) {
            
          if(  senha.equals(dbUsuarios.getUsuariobyEmail(email).getSenha())){
            System.out.println("usuario logado");
          }else {
            System.out.println("Senha errada");
          }

            
        } else {
            System.out.println("Email não cadastrado");
        }
        
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

        String fKUsuario = usuario.getId();

        Cadastro cadastro = new Cadastro(idCadastro, nome, sobrenome, telefone, dataNascimento, sexo, fKUsuario);
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