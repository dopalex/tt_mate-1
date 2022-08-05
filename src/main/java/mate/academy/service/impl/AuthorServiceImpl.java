package mate.academy.service.impl;

import mate.academy.model.Author;
import mate.academy.repository.AuthorRepository;
import mate.academy.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author getByName(String authorName) {
        return authorRepository.getAuthorByAuthorName(authorName);
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public Author getByNameLike(String like) {
        return authorRepository.getAuthorByAuthorNameLike(like);
    }
}
