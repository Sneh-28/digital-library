package com.miniproject.digital_library.dto_mapper;


import com.miniproject.digital_library.dto.BookIssueDto;
import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.BookIssueEntity;
import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.repository.impl.BookRepo;
import com.miniproject.digital_library.repository.impl.UserRepo;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class BookIssueDtoMapper {
    private final UserRepo userRepo;
    private final BookRepo bookRepo;

    public BookIssueDtoMapper(UserRepo userRepo, BookRepo bookRepo) {
        this.userRepo = userRepo;
        this.bookRepo = bookRepo;
    }

    public BookIssueEntity toEntity(BookIssueDto bookIssueDto){
        UserEntity user = this.userRepo.getUser(bookIssueDto.getUserId());
        BookEntity book = this.bookRepo.findBookById(bookIssueDto.getBookId());
        LocalDate expireDate = bookIssueDto.getStartDate().plusDays(14);

        return BookIssueEntity.builder()
                .userEntity(user)
                .bookEntity(book)
                .startDate(bookIssueDto.getStartDate())
                .expireDate(expireDate)
                .build();


    }
}
