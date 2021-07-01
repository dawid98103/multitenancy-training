package pl.kobylarz.playground.core.master.book.domain;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryBookRepository implements BookRepository {
    private ConcurrentHashMap<Integer, Book> map = new ConcurrentHashMap<>();

    @Override
    public List<Book> findAll() {
        return map.entrySet().stream()
                .map(es -> es.getValue().toBuilder().bookId(es.getKey()).build())
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Book> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Book> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Book> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Book> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Book getOne(Integer integer) {
        return null;
    }

    @Override
    public Book getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Book> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> S save(S s) {
        map.put(map.size() + 1, s);
        return (S) map.get(map.size()).toBuilder().bookId(map.size()).build();
    }

    @Override
    public Optional<Book> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
        map.remove(integer);
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Book> iterable) {
    }

    @Override
    public void deleteAll() {
        map.clear();
    }

    @Override
    public <S extends Book> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Book> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Book> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Book> boolean exists(Example<S> example) {
        return false;
    }
}
