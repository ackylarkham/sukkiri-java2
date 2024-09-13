import java.util.function.*;
public class App3 {
    public static void main(String[] args) throws Exception {

        IntPredicate func1 = x -> {
            return (x % 2) == 1;
        };
        BiFunction<Integer,String,String> func2 = (point, name) -> {
            return name + "さんは" + (point > 65 ? "合格" : "不合格");
        };

        int r = new java.util.Random().nextInt(10);
        if (func1.test(r)) {
            System.out.println(r + "は奇数です");
        } else {
            System.out.println(r + "は偶数です");
        }

        System.out.println(func2.apply(66, "ウルトラマン"));
    }
}
