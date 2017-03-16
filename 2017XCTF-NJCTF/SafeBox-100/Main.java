package test;

public class Main {
	
	public static void main(String[] args) throws Exception{
		
        for(int v4 = 10000001; v4 < 99999999; v4++) {
        	String v6 = "NJCTF{";
            
            if(v4 > 10000000 && v4 < 99999999) {
                int v7 = 1;
                int v8 = 10000000;
                int v3 = 1;
                if(Math.abs(v4 / 1000 % 100 - 36) == 3 && v4 % 1000 % 584 == 0) {
                    int v5 = 0;
                    while(v5 < 4) {
                        if(v4 / v7 % 10 != v4 / v8 % 10) {
                            v3 = 0;
                        }
                        else {
                            v7 *= 10;
                            v8 /= 10;
                            ++v5;
                            continue;
                        }

                        break;
                    }

                    if(v3 != 1) {
                        continue;
                    }

                    System.out.println(v6 + (((char)(v4 / 1000000))) + (((char)(v4 / 10000 % 100))) + (((char)(v4 / 100 % 100))) + "f4n}");
                }
            }
        }
//        System.out.println("Sorry, nothing found!\n");
		
        
//        for(int v4 = 10000001; v4 < 99999999; v4++){
//        	int v11 = 3;
//            String v6 = "NJCTF{have";
//            if(v4 > 10000000 && v4 < 99999999) {
//                int v7 = 1;
//                int v8 = 10000000;
//                int v3 = 1;
//                if(Math.abs(v4 / 1000 % 100 - 36) == v11 && v4 % 1000 % 584 == 0) {
//                    int v5 = 0;
//                    while(v5 < v11) {
//                        if(v4 / v7 % 10 != v4 / v8 % 10) {
//                            v3 = 0;
//                        }
//                        else {
//                            v7 *= 10;
//                            v8 /= 10;
//                            ++v5;
//                            continue;
//                        }
//
//                        break;
//                    }
//
//                    if(v3 != 1) {
//                        continue;
//                    }
//
//                    System.out.println(v6 + (((char)(v4 / 1000000))) + (((char)(v4 / 10000 % 100))) + (((char)(v4 / 100 % 100 + 10))) + "f4n}");
//                }
//            }
//        }
	}
}


//NJCTF{05#f4n}
//NJCTF{have05-f4n}
//NJCTF{have05if4n}
