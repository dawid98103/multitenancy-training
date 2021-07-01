package pl.kobylarz.playground.core.master.book.domain.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SaveBookDto {
    private String bookName;
    private String bookAuthor;
    private int pageQuantity;
}
