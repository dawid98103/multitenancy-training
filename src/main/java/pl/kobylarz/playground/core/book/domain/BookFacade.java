//package pl.kobylarz.playground.core.book.domain;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.transaction.annotation.Transactional;
//import pl.kobylarz.playground.core.book.domain.dto.BookDto;
//import pl.kobylarz.playground.core.book.domain.dto.SaveBookDto;
//
//import java.util.List;
//
//@Transactional
//@RequiredArgsConstructor
//public class BookFacade {
//
//    private final BookService bookService;
//
//    public Book saveBook(SaveBookDto saveBookDto) {
//        return bookService.saveBook(saveBookDto);
//    }
//
//    public List<BookDto> findAll() {
//        return bookService.findAll();
//    }
//
//    public void deleteById(int id){
//        bookService.deleteById(id);
//    }
//
//    public void deleteAll() {
//        bookService.deleteAll();
//    }
//}
