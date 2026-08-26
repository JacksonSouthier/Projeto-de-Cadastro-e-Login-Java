import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BancoDados {
    
    String nome;
    String idade;
    String senha;
    String nomeSalvo;
    String senhaSalva;

    
    public String getSenhaSalva() {
        return senhaSalva;
    }

    public void setSenhaSalva(String senhaSalva) {
        this.senhaSalva = senhaSalva;
    }

    public String getNomeSalvo() {
        return nomeSalvo;
    }

    public void setNomeSalvo(String nomeSalvo) {
        this.nomeSalvo = nomeSalvo;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    void salvarUsuario(String nome,String idade,String senha){
        try {

            FileWriter arquivo = new FileWriter("usuario.txt");
            arquivo.write("Nome: " + nome + "\n");
            arquivo.write("Idade: " + idade + "\n");
            arquivo.write("Senha: " + senha);

            arquivo.close();

        } catch (IOException e){
            System.out.println("Erro ao salvar arquivo");
        }
    }

    void consultarUsuario(){


try {
    FileReader arquivo = new FileReader("usuario.txt");
    BufferedReader leitor = new BufferedReader(arquivo);

    String linhaNome = leitor.readLine();
    String linhaIdade = leitor.readLine();
    String linhaSenha = leitor.readLine();


    leitor.close();

    nomeSalvo = linhaNome.replace("Nome: ", "");
    senhaSalva = linhaSenha.replace("Senha: ","");

if (nome.equals(nomeSalvo) && senha.equals(senhaSalva)){
System.out.println("Login realizado");
} else if (!nome.equals(nomeSalvo)) {
    System.out.println("Nome Incorreto");
}else {
    System.out.println("Senha incorreta");
}

} catch (Exception e) {
    System.out.println("Erro ao fazer Consulta");
}
    }

    void loginSalvo(){

        try {
    FileReader arquivo = new FileReader("usuario.txt");
    BufferedReader leitor = new BufferedReader(arquivo);

    String linhaNome = leitor.readLine();
    String linhaIdade = leitor.readLine();
    String linhaSenha = leitor.readLine();


    leitor.close();

        nomeSalvo = linhaNome.replace("Nome: ", "");
        senhaSalva = linhaSenha.replace("Senha: ","");
        }catch (Exception e){

        }
    }
}