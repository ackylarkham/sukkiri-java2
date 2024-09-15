import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        Reader fr = new FileReader("/home/user/sukkiri-java2/Ex07/bin/pref.properties");
        Properties p = new Properties();
        p.load(fr);
        
        System.out.println(p.getProperty("aichi.capital") + ": " + p.getProperty("aichi.food"));

        fr.close();
    }
}
