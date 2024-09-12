public class App {
    public static void main(String[] args) throws Exception {
        FuncList f = new FuncList();

        Func1 func1 = FuncList::isOdd;
        Func2 func2 = f::passCheck;

        int r = new java.util.Random().nextInt(10);
        if (func1.isOdd(r)) {
            System.out.println(r + "は奇数です");
        } else {
            System.out.println(r + "は偶数です");
        }

        System.out.println(func2.passCheck(66, "ウルトラマン"));
    }
}
