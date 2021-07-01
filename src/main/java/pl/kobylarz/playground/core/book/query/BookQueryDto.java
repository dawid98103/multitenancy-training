//package pl.kobylarz.playground.core.book.query;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.Immutable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.time.LocalDateTime;
//
//@Entity(name = "BookQuery")
//@Builder
//@Getter
//@Immutable
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "book")
//public class BookQueryDto {
//
//    @Id
//    @Column(name = "book_id")
//    private int bookId;
//
//    @Column(name = "book_name")
//    private String bookName;
//
//    @Column(name = "book_author")
//    private String bookAuthor;
//
//    @Column(name = "book_creation_date")
//    private LocalDateTime creationDate;
//}
