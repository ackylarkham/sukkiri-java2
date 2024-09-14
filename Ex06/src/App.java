import java.io.*;

public class App {

    public static void main(String[] args) throws Exception {
        
        String fromFile = args[0];
        String toFile = args[1];

        FileInputStream fr = new FileInputStream(fromFile);
        FileOutputStream fw = new FileOutputStream(toFile);

        int i = fr.read();
        while (i >= 0) {
            fw.write(i);
            i = fr.read();
        }

        fw.flush();

        fr.close();
        fw.close();
    }
}
