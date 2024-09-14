import java.util.Locale;
public class MemoryEater {
    public static void main(String[] args) throws Exception {
        Locale loc = Locale.getDefault();
        String lang = loc.getLanguage();
        if(lang.equals("jp")) {
            System.out.println("言語: " + lang + " msg: メモリを消費しています");
        } else {
            System.out.println("language: " + lang + " msg: eating memory");
        }

        long[] a;
        a = new long[1280000];

    }
}
