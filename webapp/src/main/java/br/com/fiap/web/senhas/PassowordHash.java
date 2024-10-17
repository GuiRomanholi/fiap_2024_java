package br.com.fiap.web.senhas;

import org.springframework.security.crypto.bcrypt.BCrypt;

//Aplicar o algoritmo de hash bcrypt
public class PassowordHash {
    public static String hashPassword(String senha){
       String salt = BCrypt.gensalt(10);
       String newPassword = BCrypt.hashpw(senha, salt);
       return newPassword;
    }

    public static boolean verificaSenha(String senha, String hashPassoword){
        return BCrypt.checkpw(senha, hashPassoword);
    }

}
