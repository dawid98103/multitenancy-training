//package pl.kobylarz.playground.core.book.domain;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class BookConfiguration {
//
//    BookFacade bookFacade() {
//        return bookFacade(new InMemoryBookRepository());
//    }
//
//    @Bean
//    BookFacade bookFacade(BookRepository bookRepository) {
//        BookService bookService = new BookService(bookRepository);
//        return new BookFacade(bookService);
//    }
//}
