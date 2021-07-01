package pl.kobylarz.playground.core.book.domain.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookDto {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int pageQuantity;
    private LocalDateTime creationDate;
}
