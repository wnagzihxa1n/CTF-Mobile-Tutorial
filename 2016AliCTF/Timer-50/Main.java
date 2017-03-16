package test;

public class Main {
	
	public static void main(String[] args) throws Exception{
		int beg = 200000;
		int k = 0;
		int i;
		for(i = beg; i > 0; i--){
	        if(is2(beg - i)) {
	            k += 100;
	        } else {
	            k--;
	        }
		}
		System.out.println(Integer.toString(k));
		System.out.println("Finish!");
	}
		
	public static boolean is2(long l) {
        if (l <= 3) {
            if (l > 1) {
                return true;
            }
            return false;
        } else if (l % 2 == 0 || l % 3 == 0) {
            return false;
        } else {
            int i = 5;
            while (i * i <= l) {
                if (l % i == 0 || l % (i + 2) == 0) {
                    return false;
                }
                i += 6;
            }
            return true;
        }
    }
}

