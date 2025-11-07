package com.miniproject.digital_library.service;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.BookIssueEntity;
import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.enums.SubscriptionType;
import com.miniproject.digital_library.repository.impl.BookIssueRepo;
import com.miniproject.digital_library.repository.impl.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookIssueService {
    private final BookIssueRepo bookIssueRepo;
    private final UserRepo userRepo;

    public BookIssueService(BookIssueRepo bookIssueRepo,UserRepo userRepo) {
        this.bookIssueRepo = bookIssueRepo;
        this.userRepo = userRepo;
    }

    public BookIssueEntity addIssueBook(BookIssueEntity bookIssueEntity){
        SubscriptionType subscriptionType = bookIssueEntity.getUserEntity().getSubscriptionType();
        int issuedBook = bookIssueRepo.countIssuedBooksByUser(bookIssueEntity.getUserEntity().getId());
        if(issuedBook >= subscriptionType.getBookLimit()){
            throw new RuntimeException("Book limit is exceed as per subscription" + subscriptionType);
        }
            return this.bookIssueRepo.addIssueBook(bookIssueEntity);


    }

    public  List<BookEntity> getAllIssuedBooks(int userId){
        UserEntity user = this.userRepo.getUser(userId);
        return this.bookIssueRepo.getAllIssuedBooks(user.getId());
    }
}

