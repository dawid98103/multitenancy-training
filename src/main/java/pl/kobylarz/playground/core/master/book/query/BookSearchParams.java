package pl.kobylarz.playground.core.master.book.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookSearchParams {

    private final BookQueryRepository bookQueryRepository;

    public List<BookQueryDto> findAll() {
        return bookQueryRepository.findAll();
    }
}
