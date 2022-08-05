package mate.academy.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class BookRequestDto {
    private String bookName;
    private List<Long> authorId;
    private long publishedAmount;
    private long soldAmount;
}
