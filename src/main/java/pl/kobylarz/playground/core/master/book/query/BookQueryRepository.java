package pl.kobylarz.playground.core.master.book.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookQueryRepository extends JpaRepository<BookQueryDto, Integer> {
}
