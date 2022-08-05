package mate.academy.controller;

import mate.academy.dto.request.AuthorRequestDto;
import mate.academy.dto.response.AuthorResponseDto;
import mate.academy.mapper.AuthorMapper;
import mate.academy.model.Author;
import mate.academy.service.AuthorService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController {
    private final AuthorService authorService;
    private final AuthorMapper authorMapper;

    public AuthorController(AuthorService authorService, AuthorMapper authorMapper) {
        this.authorService = authorService;
        this.authorMapper = authorMapper;
    }

    @PostMapping
    public AuthorResponseDto create(@RequestBody AuthorRequestDto request) {
        Author author = authorMapper.fromDto(request);
        return authorMapper.toDto(authorService.create(author));
    }

    @PutMapping("/{id}")
    public AuthorResponseDto update(@PathVariable Long id,
                                    @RequestBody AuthorRequestDto request) {
        Author author = authorMapper.fromDto(request);
        author.setId(id);
        return authorMapper.toDto(authorService.create(author));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }

}
