package com.nvegas.ingwebapi.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class EncryptService implements IEncryptService{
    private String KEY = "CODE01";


    private SecretKeySpec createKey(String key) {
        try {
            byte[] text = key.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            text = md.digest(text);
            text = Arrays.copyOf(text, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(text, "AES");
            return secretKeySpec;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String encrypt(String message) {
        try {
            SecretKeySpec secretKeySpec = createKey(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte [] cadena = message.getBytes("UTF-8");
            byte [] encriptada = cipher.doFinal(cadena);
            return Base64.encodeBase64String(encriptada);

        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public String decrypt(String data) {
        try {
            SecretKeySpec secretKeySpec = createKey(KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte [] cadena = Base64.decodeBase64(data);
            byte [] desencriptacion = cipher.doFinal(cadena);
            return new String(desencriptacion);

        } catch (Exception e) {
            return "";
        }
    }
}
