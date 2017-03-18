package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.omg.CORBA.StringHolder;

public class Main {
	
	public static void main(String[] args) throws Exception{
		getKeyfromURLPNG();//从url.png中获取16字节的数据作为AES加密的key
		Deryption();
	}
	
	public static void getKeyfromURLPNG() {
		try {
            File file = new File("url.png");
            FileInputStream inputStream_url_png = new FileInputStream(file);
            int url_png_length = inputStream_url_png.available();  // 获取读取到的数据长度
            byte[] url_png_byte = new byte[url_png_length];  // 定义等长byte数组
            inputStream_url_png.read(url_png_byte, 0, url_png_length);  // 将url.png的数据写到url_png_byte[]中
            byte[] v0_2 = new byte[16];
            System.arraycopy(url_png_byte, 144, v0_2, 0, 16);
            String string_url_png = new String(v0_2, "utf-8");
            System.out.println(string_url_png);
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
	}
	
	public static void Deryption() {
		String compare = new String(new byte[]{21, -93, -68, -94, 86, 117, -19, -68, -92, 33, 50, 118, 16, 13, 1, -15, -13, 3, 4, 103, -18, 81, 30, 68, 54, -93, 44, -23, 93, 98, 5, 59});
		System.out.println(compare);
		
		byte[] content = new byte[]{21, -93, -68, -94, 86, 117, -19, -68, -92, 33, 50, 118, 16, 13, 
			1, -15, -13, 3, 4, 103, -18, 81, 30, 68, 54, -93, 44, -23, 93, 98, 5, 59};
		String password = a("this_is_the_key.");
		System.out.println(password);
		
		try {  
//            KeyGenerator kgen = KeyGenerator.getInstance("AES");  
//            kgen.init(128, new SecureRandom(password.getBytes()));  
//            SecretKey secretKey = kgen.generateKey();  
//            byte[] enCodeFormat = secretKey.getEncoded();  
//            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] result = cipher.doFinal(content);  
//            System.out.println(new String(result));
            
            SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] result = cipher.doFinal(content);
            System.out.println(new String(result));
            
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}	
	
	public static String a(String input) {
        String result;
        try {
            input.getBytes("utf-8");
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            for(i = 0; i < input.length(); i += 2) {
                stringBuilder.append(input.charAt(i + 1));
                stringBuilder.append(input.charAt(i));
            }

            result = stringBuilder.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
            result = null;
        }

        return result;
    }
	
	
}


