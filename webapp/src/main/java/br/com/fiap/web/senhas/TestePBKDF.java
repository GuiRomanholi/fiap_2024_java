package br.com.fiap.web.senhas;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TestePBKDF {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String senha = "minhasenha123";
        //Gerar o salt aleatório
        byte[] salt = PassowordHashPBKDF2.generateSalt();
        System.out.println("Salt: " + Base64.getEncoder().encodeToString(salt));

        //Gerar o hash
        String hashPassword = PassowordHashPBKDF2.hashPassword(senha, salt);
        System.out.println("Senha criptografada: " + hashPassword);

        //Verifica senha
        boolean senhaValida = PassowordHashPBKDF2.verificarSenha("minhasenha123", hashPassword, salt);
        System.out.println("Senha válida? " + senhaValida);
    }
}
