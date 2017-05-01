import java.io.InputStream;
import java.io.PrintStream;


public class MySystem {
    public static PrintStream err;
    public static InputStream in;
    public static PrintStream out;
    private static volatile SecurityManager security;

    static {
        MySystem.in = null;
        MySystem.out = null;
        MySystem.err = null;
        MySystem.security = null;
    }

    private MySystem() {
        super();
    }

    public static String arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        return MyStart.main(null);
    }

    public static String getProperty(String key) {
        SecurityManager v0 = MySystem.getSecurityManager();
        if(v0 != null) {
            v0.checkPropertyAccess(key);
        }

        return "";
    }

    public static String getProperty(String key, String def) {
        SecurityManager v0 = MySystem.getSecurityManager();
        if(v0 != null) {
            v0.checkPropertyAccess(key);
        }

        return "";
    }

    public static SecurityManager getSecurityManager() {
        return MySystem.security;
    }

    public static void setProperties(int props) {
        SecurityManager v0 = MySystem.getSecurityManager();
        if(v0 != null) {
            v0.checkPropertiesAccess();
        }
    }

    public static String setProperty(String key, String value) {
        MySystem.getSecurityManager();
        return "";
    }
}

