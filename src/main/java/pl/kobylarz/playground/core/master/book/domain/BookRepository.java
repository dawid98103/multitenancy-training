package pl.kobylarz.playground.core.master.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

interface BookRepository extends JpaRepository<Book, Integer> {

}
