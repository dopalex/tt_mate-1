package mate.academy.mapper;

import java.util.stream.Collectors;
import mate.academy.dto.request.BookRequestDto;
import mate.academy.dto.response.BookResponseDto;
import mate.academy.model.Author;
import mate.academy.model.Book;
import mate.academy.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final AuthorService authorService;

    public BookMapper(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Book fromDto(BookRequestDto request) {
        Book book = new Book();
        book.setBookName(request.getBookName());
        book.setAuthor(request.getAuthorId().stream()
                .map(authorService::getById)
                .collect(Collectors.toList()));
        book.setPublishedAmount(request.getPublishedAmount());
        book.setSoldAmount(request.getSoldAmount());
        return book;
    }

    public BookResponseDto toDto(Book book) {
        BookResponseDto response = new BookResponseDto();
        response.setId(book.getId());
        response.setBookName(book.getBookName());
        response.setAuthorId(book.getAuthor().stream()
                .map(Author::getId)
                .collect(Collectors.toList()));
        response.setPublishedAmount(book.getPublishedAmount());
        response.setSoldAmount(book.getSoldAmount());
        return response;
    }
}
