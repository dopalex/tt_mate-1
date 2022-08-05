package mate.academy.service;

import mate.academy.model.Author;

public interface AuthorService {
    Author create(Author author);

    Author update(Author author);

    void delete(Long id);

    Author getByName(String authorName);

    Author getById(Long id);

    Author getByNameLike(String like);
}
