public class App2 {
    public static void main(String[] args) throws Exception {

        Func1 func1 = x -> {
            return (x % 2) == 1;
        };
        Func2 func2 = (point, name) -> {
            return name + "さんは" + (point > 65 ? "合格" : "不合格");
        };

        int r = new java.util.Random().nextInt(10);
        if (func1.isOdd(r)) {
            System.out.println(r + "は奇数です");
        } else {
            System.out.println(r + "は偶数です");
        }

        System.out.println(func2.passCheck(66, "ウルトラマン"));
    }
}
