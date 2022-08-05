package mate.academy.repository;

import mate.academy.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author getAuthorByAuthorName(String name);

    Author getAuthorById(Long id);

    Author getAuthorByAuthorNameLike(String like);
}
