package test;

public class Main {
	
	public static void main(String[] args) throws Exception{
		String seed = "m3ll0t_yetFLag";
		StringBuilder v1 = new StringBuilder(seed);
        v1.replace(0, 1, "h");
        v1.replace(5, 6, "2");
        v1.replace(10, 11, "f");
        v1.replace(7, 8, "G");
		System.out.println(v1.toString());
	}
	
	
}







