package mate.academy.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    @ManyToMany
    private List<Author> author;
    private long publishedAmount;
    private long soldAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public long getPublishedAmount() {
        return publishedAmount;
    }

    public void setPublishedAmount(long publishedAmount) {
        this.publishedAmount = publishedAmount;
    }

    public long getSoldAmount() {
        return soldAmount;
    }

    public void setSoldAmount(long soldAmount) {
        this.soldAmount = soldAmount;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", bookName='" + bookName + '\''
                + ", author=" + author
                + ", publishedAmount=" + publishedAmount
                + ", soldAmount=" + soldAmount
                + '}';
    }
}
