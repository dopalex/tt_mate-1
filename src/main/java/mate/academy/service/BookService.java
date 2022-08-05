package mate.academy.service;

import java.util.List;
import mate.academy.model.Book;

public interface BookService {
    Book create(Book book);

    Book update(Book book);

    void delete(Long id);

    List<Book> showAllBooksByAuthorName(String authorName);

    Book getById(Long id);

    Book getMostSellingBook(String authorName);

    Book getMostPublishedBook(String authorName);

    List<Book> getMostSellingBookLike(String like);

    List<Book> getMostPublishedBookLike(String like);

    List<Book> findAllByRateAndAuthorNameContains(String partName);
}
