package mate.academy.mapper;

import mate.academy.dto.request.AuthorRequestDto;
import mate.academy.dto.response.AuthorResponseDto;
import mate.academy.model.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author fromDto(AuthorRequestDto request) {
        Author author = new Author();
        author.setAuthorName(request.getAuthorName());
        author.setBirthDate(author.getBirthDate());
        author.setPhone(request.getPhone());
        author.setEmail(request.getEmail());
        return author;
    }

    public AuthorResponseDto toDto(Author author) {
        AuthorResponseDto response = new AuthorResponseDto();
        response.setId(author.getId());
        response.setAuthorName(author.getAuthorName());
        response.setBirthDate(author.getBirthDate());
        response.setPhone(author.getPhone());
        response.setEmail(author.getEmail());
        return response;
    }
}
