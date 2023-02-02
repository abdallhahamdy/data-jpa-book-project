package com.global.book.repository;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    @Override
    @EntityGraph(value = "loadAuther")
    Optional<Book> findById(Long id);

    @Override
    @EntityGraph(attributePaths = {"auther"})
    List<Book> findAll();
}
