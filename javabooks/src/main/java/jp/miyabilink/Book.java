package jp.miyabilink;
import java.time.*;
import org.apache.commons.lang3.builder.*;

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
        return EqualsBuilder.reflectionEquals(this, o);
    }

    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public int compareTo(Book obj) {
        return CompareToBuilder.reflectionCompare(this, obj);
    }

    public Book clone() {
        Book result = new Book(this.getTitle(),this.getPublishDate(),this.getComment());
        return result;
    }
}
