
import java.util.Scanner;

public class Menus {

  

BancoDados banco = new BancoDados();
LoginCadastro loginCadatro = new LoginCadastro();

    Scanner entrada = new Scanner(System.in);

    void menuPrincipal(){

System.out.println("""
        1 - Login
        2 - Cadastro
        3 - Sair
        """);

        String escolha = entrada.nextLine();
    switch (escolha) {
        case "1":
            menuLogin();
            break;
            case "2":
            loginCadatro.cadastro();
            break;
            case "3":
            return;
        default:
            throw new AssertionError();
    }
    }

    void menuLogin(){
        loginCadatro.login();
        System.out.println("Digite o nome de acesso");
        
    }
}
