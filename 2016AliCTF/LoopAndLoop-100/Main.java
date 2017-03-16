package test;

import java.awt.geom.Ellipse2D;

public class Main {
	
	public static void main(String[] args) throws Exception{
		int output = 1835996258;
		for(int i = 2; i <= 99; i++) {
			if((2 * i % 3) == 0) {
				output = check1(output, i - 1);
			} else if((2 * i % 3) == 1) {
				output = check2(output, i - 1);
			} else {
				output = check3(output, i - 1);
			}
		}
		System.out.println(Integer.toString(output));
	}

    public static int check1(int input, int s) {
        int t = input;
        for (int i = 1; i < 100; i++) {
            t -= i;
        }
        return t;
    }

    public static int check2(int input, int s) {
        int t = input;
        int i;
        if (s % 2 == 0) {
            for (i = 1; i < 1000; i++) {
                t -= i;
            }
            return t;
        }
        for (i = 1; i < 1000; i++) {
            t += i;
        }
        return t;
    }

    public static int check3(int input, int s) {
        int t = input;
        for (int i = 1; i < 10000; i++) {
            t -= i;
        }
        return t;
    }
}

