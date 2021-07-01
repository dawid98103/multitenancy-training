package pl.kobylarz.playground.core.master.book.domain;

import lombok.RequiredArgsConstructor;
import pl.kobylarz.playground.core.master.book.domain.dto.BookDto;
import pl.kobylarz.playground.core.master.book.domain.dto.SaveBookDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class BookService {

    private final BookRepository bookRepository;

    Book saveBook(SaveBookDto saveBookDto) {
        Book book = Book.builder()
                .bookId(0)
                .bookName(saveBookDto.getBookName())
                .bookAuthor(saveBookDto.getBookAuthor())
                .pageQuantity(saveBookDto.getPageQuantity())
                .creationDate(LocalDateTime.now())
                .build();
        return bookRepository.save(book);
    }

    List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    void deleteAll() {
        bookRepository.deleteAll();
    }

    void deleteById(int id){
        bookRepository.deleteById(id);
    }

    private BookDto toDto(Book book) {
        return BookDto.builder()
                .bookId(book.getBookId())
                .bookAuthor(book.getBookAuthor())
                .bookName(book.getBookName())
                .pageQuantity(book.getPageQuantity())
                .creationDate(book.getCreationDate())
                .build();
    }

    public Object test() {

    }
}
