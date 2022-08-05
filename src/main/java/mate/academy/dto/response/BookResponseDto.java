package mate.academy.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String bookName;
    private List<Long> authorId;
    private long publishedAmount;
    private long soldAmount;
}
