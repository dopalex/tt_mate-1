package mate.academy.repository;

import java.util.List;
import mate.academy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getBookByAuthorId(Long authorId);

    Book getBookById(Long id);

    @Query(value = "select * "
            + "from books "
            + "join authors "
            + "on authors.id = books.author_id "
            + "where author_name = :authorName "
            + "order by sold_amount DESC "
            + "limit 1", nativeQuery = true)
    Book findMaxSodAmount(String authorName);

    @Query(value = "select * "
            + "from books "
            + "join authors "
            + "on authors.id = books.author_id "
            + "where author_name = :authorName "
            + "order by published_amount DESC "
            + "limit 1", nativeQuery = true)
    Book findMaxPublishedAmount(String authorName);

    @Query(value = "select b.id, author_name, book_name, "
             + "published_amount, max(sold_amount) AS sold_amount "
             + "from cinema.books b "
             + "join cinema.authors a "
             + "on a.id = b.author_id "
             + "where author_name LIKE %?1% "
             + "group by author_name ", nativeQuery = true)
    List<Book> findAllByAllSoldAmountAndAuthorNameContains(String partName);

    @Query(value = "select b.id, author_name, book_name, "
            + "max(b.published_amount) AS published_amount, sold_amount  "
            + "from cinema.books b "
            + "join cinema.authors a "
            + "on a.id = b.author_id "
            + "where author_name LIKE %?1% "
            + "group by author_name", nativeQuery = true)
    List<Book> findAllByAllPublishedAmountAndAuthorNameContains(String partName);

    @Query(value = "select b.id, author_name, book_name, published_amount, sold_amount  "
            + "from cinema.books b "
            + "join cinema.authors a "
            + "on a.id = b.author_id "
            + "where author_name LIKE %?1% "
            + "having max(sold_amount / published_amount)", nativeQuery = true)
    List<Book> findAllByRateAndAuthorNameContains(String partName);
}
