package com.miniproject.digital_library.repository.impl;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.BookIssueEntity;
import com.miniproject.digital_library.repository.jpa.BookIssueJpaRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookIssueRepo {
    private final BookIssueJpaRepo bookIssueJpaRepo;

    public BookIssueRepo(BookIssueJpaRepo bookIssueJpaRepo) {
        this.bookIssueJpaRepo = bookIssueJpaRepo;
    }

    public BookIssueEntity addIssueBook(BookIssueEntity bookIssueEntity){
        return this.bookIssueJpaRepo.save(bookIssueEntity);
    }

    public int countIssuedBooksByUser(int userId){
        return this.bookIssueJpaRepo.countIssuedBooksByUser(userId);
    }

    public List<BookEntity> getAllIssuedBooks(int userId){
        return this.bookIssueJpaRepo.getAllIssuedBooks(userId);
    }






}
