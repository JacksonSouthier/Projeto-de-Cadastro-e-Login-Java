package org.example;

import java.sql.*;
import java.util.spi.AbstractResourceBundleProvider;

public class BancoDeDados {
Connection conexao = Conectar();

public Connection Conectar() {
    // Altere a url, usuario e senha se necessario.
    String url = "jdbc:mysql://localhost:3306/";
    String usuario = "root";
    String senha = "1234";
    try {
        return DriverManager.getConnection(url, usuario, senha);
    } catch (Exception e) {
        System.out.println(e);
return  null;
    }
}
void criarDATABASE(){
//    Deixei este metodo responsavel por criar toda a estrutura de database e tabelas, para evitar que
//    futuramente eu precise usar algum metodo separado so para criar uma tabela. Acho que desta forma fica
//    mais simples, facil e pratico
    try (PreparedStatement comando = conexao.prepareStatement("CREATE DATABASE IF NOT EXISTS sistema")){
        comando.executeUpdate();
        try (PreparedStatement comando1 = conexao.prepareStatement("USE sistema")){
            comando1.executeUpdate();
        try(PreparedStatement comando2 = conexao.prepareStatement("CREATE TABLE IF NOT EXISTS usuarios(id INTEGER PRIMARY KEY AUTO_INCREMENT, nome VARCHAR (30), login VARCHAR (30) UNIQUE, senha VARCHAR (30))")){
            comando2.executeUpdate();
        }
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}
void cadastrarUsuario(String nome, String login, String senha){
/*
Aqui é onde o SQL ira ficar reponsavel em validar se o LOGIN ja existe, se sim, ira adicionar na tabela
o nome, login e senha de acordo com oque o usuario digitou.
 Se nao ira
 */
        try (PreparedStatement comando = conexao.prepareStatement("INSERT INTO usuarios (nome, login, senha) VALUES (?,?,?)")) {

            comando.setString(1, nome);
            comando.setString(2, login);
            comando.setString(3, senha);
            comando.executeUpdate();

        } catch (SQLException e) {
        System.out.println("Este Login " + login + " ja esta em uso, tente outro");
        }
}
void loginUsuario(String nome, String login, String senha){
//    Usando a mesma logica para segurança do Banco de dados, este metodo ta responsavel em fazer uma busca de acordo
//    com o nome ou login inserido pelo usuario, tambem com o tratamento adequado caso nao exista ou nao ache um
//            nome ou login para realizar o login
    try(PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuarios WHERE (login = ? AND nome = ?) AND senha = ?")){
        comando.setString(1, login);
        comando.setString(2, nome);
        comando.setString(3, senha);
        ResultSet resultSet = comando.executeQuery();
        if(resultSet.next()) {
            System.out.println("Login feito com sucesso!");
        } else {
            System.out.println("Nome, Login ou senha incorreto!");
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
void alterarSenha(String nome, String login, String senha){
    /*
    Fiz este metodo apenas para complementar um pouco no CRUD do sistema.
    Funciona conforme o esperado, não ha uma segurança
    de alto nivel profissional ou criptografia.
    Alterando a senha do usuario correspondente ao login e nome digitado pelo usuario.
     */
    try (PreparedStatement comando = conexao.prepareStatement("UPDATE usuarios SET senha = ? WHERE login = ? AND nome = ?")){
        conexao.setAutoCommit(false);
        comando.setString(1, senha);
        comando.setString(2, login);
        comando.setString(3, nome);
        int resultSet = comando.executeUpdate();
        if(resultSet > 0) {
            System.out.println("Senha alterado com sucesso!");
            conexao.commit();
        } else {
            System.out.println("Nome ou Login incorreto!");
            conexao.rollback();
        }
    }catch (Exception e){
        throw new RuntimeException(e);
    }
}
void mostrarUSuarios(){
    try(PreparedStatement comando = conexao.prepareStatement("SELECT * FROM usuarios")){
        ResultSet resultSet = comando.executeQuery();
        while(resultSet.next()){
            System.out.println("Nome: " + resultSet.getString("nome") + " | Login: " + resultSet.getString("login") + " | Senha: " + resultSet.getString("senha"));
        }
    }catch (Exception e){
        throw new RuntimeException(e);
    }
}
void limparUsuarios(){
    try(PreparedStatement comando = conexao.prepareStatement("DELETE FROM usuarios")){
        comando.executeUpdate();
    } catch (Exception e){
        throw new RuntimeException(e);
    }
}
}
