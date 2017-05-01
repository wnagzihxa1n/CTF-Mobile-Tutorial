public class MyClass {
    static String String_1;
    static String String_2;

    static {
        MyClass.String_2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        MyClass.String_1 = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    }

    public MyClass() {
        super();
    }

    static int intToPseudoUnsignedint(int n) {
        if(n < 0) {
            n += 256;
        }

        return n;
    }

    public static String signedBytesToIntsString(byte[] byteArray) {
        String v1 = "";
        int v0;
        for(v0 = 0; v0 < byteArray.length; ++v0) {
            v1 = String.valueOf(v1) + " " + Byte.toString(byteArray[v0]);
        }

        return v1;
    }

    public static String unsignedBytesToIntsString(byte[] byteArray) {
        String v1 = "";
        int v0;
        for(v0 = 0; v0 < byteArray.length; ++v0) {
            v1 = String.valueOf(v1) + " " + MyClass.intToPseudoUnsignedint(byteArray[v0]);
        }

        return v1;
    }

    public static boolean checkRegCode(String inputRegCode) {
        int num_5 = 5;
        int num_4 = 4;
        boolean result = false;
        if(inputRegCode != null && inputRegCode.length() == 19) {
            MyClass.String_2 = MySystem.arraycopy(MyClass.String_1, 0, MyClass.String_2, num_5, num_5);
            result = true;
            int k = 0;
            int i;
            for(i = 0; i < num_4; ++i) {
                int j;
                for(j = 0; j < num_4; ++j) {
                	int index = k + j;
                	System.out.print(MyClass.String_2.charAt(MyStart.judge(k + j, MyClass.String_2)));
                    if(inputRegCode.charAt(k + j) != MyClass.String_2.charAt(MyStart.judge(k + j, MyClass.String_2))) {
                        result = false;
                    }
                }
                System.out.print("-");
                k += 5;
            }
        }

        return result;
    }
}

