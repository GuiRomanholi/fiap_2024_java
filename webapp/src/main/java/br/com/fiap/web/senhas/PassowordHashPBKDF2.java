package br.com.fiap.web.senhas;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class PassowordHashPBKDF2 {

    //Parâmetros: tamanho do salt, n. itarações, comprimento da chave (bits)
    private static final int SALT = 16;
    private static final int INTERACTIONS = 65536;
    private static final int KEY = 512;
    public static byte[] generateSalt(){
        SecureRandom ramdom = new SecureRandom();
        byte[] newSalt = new byte[SALT];
        ramdom.nextBytes(newSalt);
        return newSalt;
    }

    public static String hashPassword(String senha, byte[] salt){
        KeySpec spec = new PBEKeySpec(senha.toCharArray(), salt, INTERACTIONS, KEY);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hash);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    //Método para verficar a senha
    public static boolean verificarSenha(String senha, String senhaHash, byte[] salt){
        String newHash = hashPassword(senha, salt);
        return newHash.equals(senhaHash);
    }

}
