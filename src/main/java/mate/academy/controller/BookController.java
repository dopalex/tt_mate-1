package mate.academy.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.dto.request.BookRequestDto;
import mate.academy.dto.response.BookResponseDto;
import mate.academy.mapper.BookMapper;
import mate.academy.model.Book;
import mate.academy.service.BookService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public BookResponseDto create(@RequestBody BookRequestDto request) {
        Book book = bookMapper.fromDto(request);
        return bookMapper.toDto(bookService.create(book));
    }

    @PutMapping("/{id}")
    public BookResponseDto update(@PathVariable Long id,
                                  @RequestBody BookRequestDto request) {
        Book book = bookMapper.fromDto(request);
        book.setId(id);
        return bookMapper.toDto(bookService.update(book));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @GetMapping
    public List<BookResponseDto> getBooksByAuthorName(@RequestParam String authorName) {
        return bookService.showAllBooksByAuthorName(authorName).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("most-sold")
    public BookResponseDto mostSellingBook(@RequestParam String authorName) {
        return bookMapper.toDto(bookService.getMostSellingBook(authorName));
    }

    @GetMapping("most-published")
    public BookResponseDto mostPublishedBook(@RequestParam String authorName) {
        return bookMapper.toDto(bookService.getMostPublishedBook(authorName));
    }

    @GetMapping("by-sold")
    public List<BookResponseDto> mostSellingBookPartialSearch(@RequestParam String partAuthorName) {
        return bookService.getMostSellingBookLike(partAuthorName).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("by-published")
    public List<BookResponseDto> mostPublishedBookPartialSearch(@RequestParam String partName) {
        return bookService.getMostPublishedBookLike(partName).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("by-success-rate")
    public List<BookResponseDto> findAllByRateAndAuthorNameContains(@RequestParam String partName) {
        return bookService.findAllByRateAndAuthorNameContains(partName).stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }
}
