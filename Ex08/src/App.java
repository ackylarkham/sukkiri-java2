import java.io.*;
import java.net.*;

public class App {
    public static void main(String[] args) throws Exception {

        URI uri = new URI("https://dokojava.jp/favicon.ico");
        URL url = uri.toURL();
        InputStream is = url.openStream();
        FileOutputStream fos = new FileOutputStream("dj.ico");
        int i = is.read();
        while (i >= 0) {
            fos.write((byte)i);
            i = is.read();
        }
        fos.flush();
        fos.close();
        is.close();
    }
}
