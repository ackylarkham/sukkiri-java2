import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Book b1 = new Book("タイトル0",LocalDate.parse("2024-09-11",fmt), "ほげほげ");
        Book b2 = b1.clone();

        if (b1.equals(b2)) {
            System.out.println("同じです");
        } else {
            System.out.println("違います");
        }
        System.out.println("タイトル: " + b1.getTitle() + " 発行日: " + b1.getPublishDate());
        System.out.println("タイトル: " + b2.getTitle() + " 発行日: " + b2.getPublishDate());
    
        b2.setTitle("ああああ");

        if (b1.equals(b2)) {
            System.out.println("同じです");
        } else {
            System.out.println("違います");
        }
        System.out.println("タイトル: " + b1.getTitle() + " 発行日: " + b1.getPublishDate());
        System.out.println("タイトル: " + b2.getTitle() + " 発行日: " + b2.getPublishDate());

        Set<Book> books = new HashSet<Book>();
        books.add(new Book("Java入門",LocalDate.parse("2011-10-07",fmt), "スッキリわかる"));
        books.add(new Book("Python入門",LocalDate.parse("2019-06-11",fmt), "カレーが食べたくなる"));
        books.add(new Book("C言語入門",LocalDate.parse("2018-06-21",fmt), "ポインターも自由自在"));
        List<Book> bookList = new ArrayList<Book>();
        System.out.println("=== hashSet ===");
        for (Book b : books) {
            System.out.println(b.getTitle() + " " + b.getPublishDate() + " " + b.getComment());
            bookList.add(b);
        }

        Collections.sort(bookList);
        System.out.println("=== ArrayList ソート後 ===");
        for (Book b : bookList) {
            System.out.println(b.getTitle() + " " + b.getPublishDate() + " " + b.getComment());
        }

        Collections.sort(bookList,new TitleComparator());
        System.out.println("=== ArrayList タイトルでソート後 ===");
        for (Book b : bookList) {
            System.out.println(b.getTitle() + " " + b.getPublishDate() + " " + b.getComment());
        }
    }
}
