package test;

public class Main {
	
	public static void main(String[] args) throws Exception{

		String result = "";
        int t = 51;
        String[] paname = "com.njctf.mobile.easycrack".split("\\.");
        for (char ch : paname[paname.length - 1].toCharArray()) {
        	//System.out.println(ch);
            t ^= ch;
            result = result + ((char) t);
        }
        System.out.println(result);
	}
}

