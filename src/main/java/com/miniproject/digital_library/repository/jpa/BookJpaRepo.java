package com.miniproject.digital_library.repository.jpa;

import com.miniproject.digital_library.entity.BookEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookJpaRepo extends JpaRepository<BookEntity,Integer> {
    Optional<BookEntity>findByIsbn(String isbn);

    Optional<BookEntity>findByTitle(String title);

    Optional<BookEntity>findByAuthor(String author);

    void deleteByIsbn(String isbn);

}
