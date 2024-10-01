package jp.miyabilink;
import java.time.*;
import org.apache.commons.lang3.builder.*;

/**
 * 書籍クラス
 * このクラスは、1冊の書籍を表す
 */
public class Book implements Comparable<Book>, Cloneable {
    /** タイトル */
    private String title;
    /** 発行日 */
    private LocalDate publishDate;
    /** コメント */
    private String comment;

    /**
     * コンストラクター
     * @param title タイトル
     * @param date 発行日
     * @param comment コメント
     */
    public Book(String title, LocalDate date, String comment) {
        this.setTitle(title);
        this.setPublishDate(date);
        this.setComment(comment);
    }

    /**
     * 書籍のタイトルを取得するメソッド
     * @return 書籍のタイトル
     */
    public String getTitle() {
        return this.title;
    }
    
    /**
     * 書籍のタイトルを設定するメソッド
     * @param title 書籍のタイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 書籍の発行日を取得するメソッド
     * @return 発行日
     */
    public LocalDate getPublishDate() {
        return this.publishDate;
    }

    /**
     * 書籍の発行日を設定するメソッド
     * @param date 発行日
     */
    public void setPublishDate(LocalDate date) {
        this.publishDate = date;
    }

    /**
     * 書籍のコメントを取得するメソッド
     * @return comment コメント
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * 書籍のコメントを設定するメソッド
     * @param comment コメント
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * インスタンスの等価判定を行うメソッド
     * @param o 書籍インスタンス
     */
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    /**
     * ハッシュ値を得るメソッド
     * @return ハッシュ値
     */
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * インスタンスの順序を判定する
     * @param obj 書籍のインスタンス
     * @return -1 自分自身よりパラメーターで渡されたインスタンスの方が大きい
     * 0　自分自身とパラメーターで渡されたインスタンスが等しい
     * 1　自分自身よりパラメーターで渡されたインスタンスの方が小さい
     */
    public int compareTo(Book obj) {
        return CompareToBuilder.reflectionCompare(this, obj);
    }

    /**
     * インスタンスの複製を行う
     * @return 複製されたインスタンス
     */
    public Book clone() {
        Book result = new Book(this.getTitle(),this.getPublishDate(),this.getComment());
        return result;
    }
}
