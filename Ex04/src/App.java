import java.lang.reflect.*;
public class App {
    public static void main(String[] args) throws Exception {

        //System.out.println("引数0 " + args[0] + " 引数1 " + args[1]);

        String fqcn = args[0];       //FQCN
        String execType = args[1];   //起動方法

        usedMemory();               //使用済メモリーサイズを表示 

        Class<?> c = Class.forName(fqcn);

        listMethodName(c);       //メソッド名を表示

        try {
            if (execType.equals("E")) {
                execExternal(c);
            } else if (execType.equals("I")) {
                execInternal(c);
            } else {
                throw new IllegalArgumentException("起動方法が正しくない");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        
        usedMemory();               //使用済メモリーサイズを表示
        
        System.exit(0);
    }

    public static void usedMemory() {
        long freeMemory = Runtime.getRuntime().freeMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long usedMemory = (totalMemory - freeMemory) / 1024 / 1024;    
        System.out.println("使用済メモリ = " + usedMemory + "MB" );
    }

    public static void listMethodName (Class<?> c) {
        System.out.println(c.getName() + "のメソッド一覧");
        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m.getName());
        }
    }

    public static void execExternal(Class<?> c) throws Exception {
        System.out.println("外部起動");
        ProcessBuilder pb = new ProcessBuilder("java",c.getName());
        Process proc = pb.start();
        proc.waitFor();
    }

    public static void execInternal(Class<?> c) throws Exception {
        System.out.println("内部起動");
        Method m = c.getMethod("main",String[].class);
        String[] args = {};
        m.invoke(null, (Object)args);
    }
}
