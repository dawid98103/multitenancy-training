package pl.kobylarz.playground.core.master.book.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pl.kobylarz.playground.core.master.book.domain.dto.BookDto;
import pl.kobylarz.playground.core.master.book.domain.dto.SaveBookDto;

import java.util.List;

class BookSpec {
    BookFacade bookFacade = new BookConfiguration().bookFacade();

    @AfterEach
    public void cleanUp() {
        bookFacade.deleteAll();
    }

    @Test
    public void should_add_a_film() {
        //  Given
        SaveBookDto book = SaveBookDto.builder()
                .bookName("Chłopi")
                .bookAuthor("Adam Mickiewicz")
                .pageQuantity(240)
                .build();
        //  When
        bookFacade.saveBook(book);

        //  Then
        List<BookDto> savedBooks = bookFacade.findAll();
        Assertions.assertThat(savedBooks.size()).isEqualTo(1);

        BookDto savedBook = savedBooks.get(0);

        Assertions.assertThat(savedBook.getBookId()).isGreaterThan(0);
        Assertions.assertThat(savedBook.getBookName()).isEqualTo(book.getBookName());
        Assertions.assertThat(savedBook.getBookAuthor()).isEqualTo(book.getBookAuthor());
        Assertions.assertThat(savedBook.getPageQuantity()).isEqualTo(book.getPageQuantity());
    }

    @Test
    public void should_remove_a_film_by_identifier() {
        //  Given
        SaveBookDto book = SaveBookDto.builder()
                .bookName("Chłopki")
                .bookAuthor("Adam Mickiewicz")
                .pageQuantity(240)
                .build();
        //  When
        Book savedBook = bookFacade.saveBook(book);
        Assertions.assertThat(savedBook).isNotNull();

        bookFacade.deleteById(savedBook.getBookId());
        //  Then
        List<BookDto> savedBooks = bookFacade.findAll();
        Assertions.assertThat(savedBooks.size()).isEqualTo(0);
    }
}
