package org.example;

import java.util.Scanner;

public class Controller {
Scanner entrada = new Scanner(System.in);

String nome;
String login;
String senha;

public Controller(BancoDeDados bd) {
    this.bd = bd;
}

BancoDeDados bd;
void menuPrincipal(){
    while(true) {
        System.out.println("""
                MENU INICIAL
                
                [1] - Login
                [2] - Cadastro
                [3] - Mostrar Usuarios
                [4] - Limpar Usuarios
                [0] - Sair""");
        String opc = entrada.nextLine();
        if (opc == null) {
            System.out.println("Invalido!");
            continue;
        }
        switch (opc) {
            case "1":
                System.out.println("Digite o nome");
                System.out.println("\nDigite [1] para alterar a senha");
                    nome = entrada.nextLine();
                if(nome.equals("1")) {
                    System.out.println("Digite o nome ou login para alterar a senha");
                    nome = entrada.nextLine();
                    if (nome == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    System.out.println("Digite uma nova senha");
                    senha = entrada.nextLine();
                    if(senha ==  null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    bd.alterarSenha(nome, login, senha);
                    continue;
                } else {
                    System.out.println("Digite o Login");
                    login = entrada.nextLine();
                    if (login == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    System.out.println("Digite sua Senha: ");
                    senha = entrada.nextLine();
                    if (senha == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    bd.loginUsuario(nome, login, senha);
                }
                break;
                case "2":
                    System.out.println("Digite seu Nome: ");
                    nome = entrada.nextLine();
                    if (nome == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    System.out.println("Digite seu Login: ");
                    login = entrada.nextLine();
                    if (login == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    System.out.println("Digite sua senha: ");
                    senha = entrada.nextLine();
                    if (senha == null) {
                        System.out.println("Invalido!");
                        continue;
                    }
                    bd.cadastrarUsuario(nome, login, senha);
                    break;
                    case "3":
                        bd.mostrarUSuarios();
                        break;
            case "4":
                bd.limparUsuarios();
                break;
            case "0":
                System.out.println("Saindo");
                break;
                default:
                    System.out.println("Invalido!");
                    break;
        }
        break;
    }
}
}
