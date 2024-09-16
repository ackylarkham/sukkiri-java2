import java.util.*;
public class App2 {
    public static void main(String[] args) throws Exception {
        try {
            int price = 6;
            System.out.println(price + "円以上のアイテム一覧を表示します");            
            ArrayList<Item> items = ItemsDAO.findByMinimumPrice(price);
            for (Item item : items) {
                System.out.printf("%-10s%4d%4d\r\n",
                    item.getName(), item.getPrice(), item.getWeight());
            }     
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
