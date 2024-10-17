package br.com.fiap.web.senhas;

public class TesteBCrypt {
    public static void main(String[] args) {
        String senha = "minhasenha123";
        String senhaHash = PassowordHash.hashPassword(senha);
        System.out.println("Senha Criptografada: " + senhaHash);

        //Verificação
        boolean senhaValida = PassowordHash.verificaSenha("minhasenha123", senhaHash);
        System.out.println("A senha é válida: " + senhaValida);

    }
}
