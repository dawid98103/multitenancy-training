package pl.kobylarz.playground.core.book.domain.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CardRegisterResponse {
    private String id;
    private String number;
    private String provider;
    private String expiry;
}
