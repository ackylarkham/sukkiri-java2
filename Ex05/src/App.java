import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Book b1 = new Book("タイトル0",LocalDate.parse("2024-09-11",fmt), "ほげほげ");
        Book b2 = b1.clone();
        
        compareBook(b1, b2);

        b2.setTitle("ああああ");

        compareBook(b1, b2);
        
    }

    public static void compareBook(Book b1, Book b2) {

        System.out.println("タイトル: " + b1.getTitle() + " 発行日: " + b1.getPublishDate() + " コメント: " + b1.getComment());
        System.out.println("タイトル: " + b2.getTitle() + " 発行日: " + b2.getPublishDate() + " コメント: " + b2.getComment());

        if (b1.equals(b2)) {
            System.out.println("同じです");
        } else {
            System.out.println("違います");
        }
    }
}
