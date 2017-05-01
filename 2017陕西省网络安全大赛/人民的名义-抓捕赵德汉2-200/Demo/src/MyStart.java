class MyStart {
    MyStart() {
        super();
    }

    public static String bytesToBinString(byte[] byteArray) {
        String v3 = "";
        int v0;
        for(v0 = 0; v0 < byteArray.length; ++v0) {
            String v2 = Integer.toBinaryString(MyClass.intToPseudoUnsignedint(byteArray[v0]));
            int v1;
            for(v1 = v2.length(); v1 < 8; ++v1) {
                v2 = "0" + v2;
            }

            v3 = String.valueOf(v3) + " " + v2;
        }

        return v3;
    }

    public static String main(String[] args) {
        String v1 = "";
        char[] v3 = "vÈ¾¤ÊÊ¬ÆÆÊvÌ¤Ê²Ê²ÀÎ¤¨¸¬".toCharArray();
        int v4 = v3.length;
        int v2;
        for(v2 = 0; v2 < v4; ++v2) {
            v1 = String.valueOf(v1) + (((char)((v3[v2] >> 1) + 15)));
        }

        return v1;
    }

    public static int run(String[] args) {
        int v0 = Integer.parseInt(args[0]);
        boolean[] v2 = new boolean[v0 + 1];
        int v1;
        for(v1 = 2; v1 <= v0; ++v1) {
            v2[v1] = true;
        }

        for(v1 = 2; v1 * v1 <= v0; ++v1) {
            if(v2[v1]) {
                int v3;
                for(v3 = v1; v1 * v3 <= v0; ++v3) {
                    v2[v1 * v3] = false;
                }
            }
        }

        int v4 = 0;
        for(v1 = 2; v1 <= v0; ++v1) {
            if(v2[v1]) {
                ++v4;
            }
        }

        return v0;
    }

    public static int judge(int index, String MyClass_String2) {
        return MyStart.judge2(index) % MyClass_String2.length();
    }

    private static int judge2(int index) {
        int v0 = index > 2 ? MyStart.judge2(index - 1) + MyStart.judge2(index - 2) : 1;
        return v0;
    }
}

