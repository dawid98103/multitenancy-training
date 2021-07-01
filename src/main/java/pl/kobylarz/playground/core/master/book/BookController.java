package pl.kobylarz.playground.core.master.book;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kobylarz.playground.core.master.book.domain.BookFacade;
import pl.kobylarz.playground.core.master.book.domain.dto.SaveBookDto;
import pl.kobylarz.playground.core.master.book.query.BookQueryDto;
import pl.kobylarz.playground.core.master.book.query.BookSearchParams;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
class BookController {

    private final BookFacade bookFacade;
    private final BookSearchParams bookSearchParams;

    @PostMapping("")
    ResponseEntity<?> saveBook(@RequestBody SaveBookDto saveBookDto) {
        bookFacade.saveBook(saveBookDto);
        return ResponseEntity.ok("Pomyślnie dodano książkę");
    }

    @GetMapping("/test")
    ResponseEntity<?> test(){
        return ResponseEntity.ok(bookFacade.test());
    }

    @GetMapping("")
    ResponseEntity<List<BookQueryDto>> findAll() {
        return ResponseEntity.ok(bookSearchParams.findAll());
    }
}
