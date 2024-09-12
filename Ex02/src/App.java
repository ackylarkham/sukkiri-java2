public class App {
    public static void main(String[] args) throws Exception {

        StrongBox<String> sb1 = new StrongBox<String>(KeyType.FINGER);

        sb1.put("鍵が開いた！");

        long retryCount = 0;
        String lock;
        for (long i = 1; i < 10000000; i++) {
            lock = sb1.get();
            if (lock == null) {
                //NOP                
            } else {
                retryCount = i;
                break;
            }
        }

        System.out.println("鍵タイプ: " + sb1.getKeyType() + " 試行回数: " + retryCount);
    }
}
