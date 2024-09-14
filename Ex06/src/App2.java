import java.io.*;
import java.util.zip.*;

public class App2 {

    public static void main(String[] args) {
        
        String fromFile = args[0];
        String toFile = args[1];
        try (
            FileInputStream fr = new FileInputStream(fromFile);
            FileOutputStream fw = new FileOutputStream(toFile);
            BufferedOutputStream bw = new BufferedOutputStream(fw);
            GZIPOutputStream zw = new GZIPOutputStream(bw);
        )   {
                int i = fr.read();
                while (i >= 0) {
                    zw.write(i);
                    i = fr.read();
            }
            
            zw.flush();   
        } catch (IOException e) {
            System.out.println("ファイルI/Oエラーが発生しました");
        }
    }
}
