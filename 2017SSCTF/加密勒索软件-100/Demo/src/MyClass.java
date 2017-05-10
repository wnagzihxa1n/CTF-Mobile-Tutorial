import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;

public class MyClass {

	static byte[] k1;
	static String MD5_KEY = "a056d5ab1fa5c250c293a5b7588d0749";
	
	public static void main(String[] args) throws Exception {
		for(int i = 100000; i < 999999; i++) {
			verify(MD5_KEY);
			//printByteHex(k1);
			if(check(String.valueOf(i), i)) {
				System.out.println("Find it : ctf1_decode_" + i + ".xlsx");
			}
		}
	}
	
	private static void printByteHex(byte[] Data) {
		int len = Data.length;
		for (int i = 0; i < len; i++) {
			String temp = Integer.toHexString(Data[i] & 0xFF);
			if (temp.length() == 1) {
				temp = "0" + temp;
			}
			System.out.print(", 0x" + temp);
		}
		System.out.println("");
	}
	
	private static void verify(String key) {
        k1 = SHA(key).getBytes();
        for(int i = 0; i < k1.length; i++) {
            for(int j = 0; j < k1.length; j++) {
                k1[(i * j * 7 + 9) % k1.length] = ((byte)((k1[i] ^ j * 5) % 127));
            }
        }
    }
	
	private static String SHA(String decript) {
        int i = 0;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(decript.getBytes("utf-8"));
            byte[] sourceData = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            int len = sourceData.length;
            while(i < len) {
                String temp = Integer.toHexString(sourceData[i] & 0xFF);
                if(temp.length() < 2) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(temp);
                ++i;
            }
            String result = stringBuffer.toString();
            return result;
        }
        catch(Exception v2) {
            v2.printStackTrace();
            return "";
        }
    }
	
	private static boolean check(String key, int index) {
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                k1[(i + 17) * (j + 5) % k1.length] = ((byte)((k1[i * j % k1.length] ^ key.charAt(i * j % key.length()) * 7) % 127));
            }
        }
        if(MyClass.encode(k1, index)) {
        	return true;
        }
        return false;
    }
	
	private static boolean encode(byte[] key, int index) {
        try {
        	//printByteHex(key);
            File file = new File("ctf1_encode.xlsx");
            if (!file.exists()) {
            	System.out.println("ctf1_encode.xlsx does not exist");
        		return false;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] temp = new byte[fileInputStream.available()];
            fileInputStream.read(temp);
            for(int i = 0; i < temp.length; i += 256) {
                temp[i] = ((byte)(temp[i] ^ key[i % key.length]));
            }
            if ((temp[0x00] != 'P') || (temp[0x100] != 0x00) || (temp[0x200] != 0x00) || (temp[0x400] != 0x00) || (temp[0x500] != 0x00)) {
	            fileInputStream.close();
				return false;
			}
            File output = new File("ctf1_decode_" + index + ".xlsx");
        	FileOutputStream fileOutputStream = new FileOutputStream(output);
            fileOutputStream.write(temp);
            fileOutputStream.close();
            fileInputStream.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
