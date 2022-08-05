package mate.academy.service.impl;

import java.util.List;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import mate.academy.service.AuthorService;
import mate.academy.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> showAllBooksByAuthorName(String authorName) {
        Long authorId = authorService.getByName(authorName).getId();
        return bookRepository.getBookByAuthorId(authorId);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book getMostSellingBook(String authorName) {
        return bookRepository.findMaxSodAmount(authorName);
    }

    @Override
    public Book getMostPublishedBook(String authorName) {
        return bookRepository.findMaxPublishedAmount(authorName);
    }

    @Override
    public List<Book> getMostSellingBookLike(String like) {
        return bookRepository.findAllByAllSoldAmountAndAuthorNameContains(like);
    }

    @Override
    public List<Book> getMostPublishedBookLike(String like) {
        return bookRepository.findAllByAllPublishedAmountAndAuthorNameContains(like);
    }

    @Override
    public List<Book> findAllByRateAndAuthorNameContains(String partName) {
        return bookRepository.findAllByRateAndAuthorNameContains(partName);
    }
}
