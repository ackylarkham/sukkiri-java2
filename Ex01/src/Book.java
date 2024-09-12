import java.util.*;
import java.time.*;

public class Book implements Comparable<Book>, Cloneable {
    private String title;
    private LocalDate publishDate;
    private String comment;

    public Book(String title, LocalDate date, String comment) {
        this.setTitle(title);
        this.setPublishDate(date);
        this.setComment(comment);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    public void setPublishDate(LocalDate date) {
        this.publishDate = date;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean equals(Object o) {

        if (o == this) {            //比較対象が自分自身だった
            return true;
        }

        if (o == null) {            //比較対象がnullだった
            return false;
        }
        
        if (o instanceof Book) {    //比較対象がBookのインスタンスだった
            Book b = (Book)o;
            if (this.getTitle().equals(b.getTitle()) && this.getPublishDate() == b.getPublishDate()) {
                                    //タイトルと発行日が同じ？
                return true;
            } else {
                return false;
            }
        } else {                    //Bookのインスタンスではなかった
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(this.getTitle(), this.getPublishDate());
    }

    public int compareTo(Book obj) {
        if (this.getPublishDate().isAfter(obj.getPublishDate())) {
            return 1;
        } else if (this.getPublishDate().isBefore(obj.getPublishDate())) {
            return -1;
        } else {
            return 0;
        }
    }

    public Book clone() {
        Book result = new Book(this.getTitle(),this.getPublishDate(),this.getComment());
        return result;
    }
}
