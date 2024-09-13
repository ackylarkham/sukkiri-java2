import java.util.*;

public class App4 {
    public static void main(String[] args) throws Exception {
        List<String> names = new ArrayList<String>();       //登場人物
        names.add("菅原拓真");
        names.add("湊雄輔");
        names.add("大江岳人");
        names.add("朝香あゆみ");

        names.stream()
            .filter(n -> n.length() <= 4)
            .map(n -> n + "さん")
            .forEach(System.out::println);
    }

}
