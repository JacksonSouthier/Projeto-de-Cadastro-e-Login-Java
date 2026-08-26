import java.util.Scanner;

public class LoginCadastro{
    BancoDados banco = new BancoDados();

Scanner entrada = new Scanner(System.in);


    void cadastro(){
        
        System.out.println("Digite seu Nome");
        String nome = entrada.nextLine();
        System.out.println("Digite a sua idada");
        String idade = entrada.nextLine();
        System.out.println("Digite uma Senha"+ "\nMAS ATENÇÃO, SE ERRAR MAIS QUE 3 VEZEZ"+"\nSUA CONTA SERA APAGADA"+
            "\nNão tenha medo, mais tarde poderá fazer uma  conta nova"
        );
        System.out.println("Sua nova Senha");
        String senha = entrada.nextLine();
        try {
            System.out.println("Carregando...");
            Thread.sleep(2300);
        } catch (Exception e) {
            System.out.println("Vamos lá!");
        }
        try {
            banco.salvarUsuario(nome, idade, senha);
                    System.out.println("Cadastro feito com sucesso");
        System.out.println("Nome de acesso: " + nome +"\nSenha de acesso: " + senha);
        } catch (Exception e) {
            System.out.println("Houve um erro no cadastro, tente novamente");
        }
    }

    void login(){
banco.loginSalvo();

System.out.println("Dgite o nome de acesso e senha");
        String acesso = entrada.nextLine();
        String senhaDeAcesso = entrada.nextLine();

        if (acesso.equals(banco.getNomeSalvo()) && senhaDeAcesso.equals(banco.getSenhaSalva())){
System.out.println("Login realizado com sucesso");
        }else {System.out.println("Acesso ou Senha Incorretos! Tente Novamente.");}
    }
}

