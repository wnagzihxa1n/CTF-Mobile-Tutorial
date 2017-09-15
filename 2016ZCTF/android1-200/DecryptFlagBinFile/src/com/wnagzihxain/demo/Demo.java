package com.wnagzihxain.demo;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;

public class Demo {

    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = null;
        byte[] buffer = new byte[16];
        try {
            fileInputStream = new FileInputStream(new File("flag.bin"));
            System.out.println(fileInputStream.available());
            do {
            } while (fileInputStream.read(buffer) > 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        StringBuilder stringBuilder = new StringBuilder(new String(decrypt(buffer, "zctf2016"))).reverse();
        System.out.println(stringBuilder);
    }

    public static byte[] decrypt(byte[] src, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        SecretKey securekey = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(password.getBytes()));
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        return cipher.doFinal(src);
    }
}
