package com.miniproject.digital_library.service;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.UserEntity;
import com.miniproject.digital_library.repository.impl.BookIssueRepo;
import com.miniproject.digital_library.repository.impl.UserRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BookIssueServiceTest {

    @InjectMocks
    private BookIssueService bookIssueService;

    @Mock
    private BookIssueRepo bookIssueRepo;

    @Mock
    private UserRepo userRepo;

    @Test
    void testGetAllIssuedBooks(){
        int userId = 1;

        UserEntity user = new UserEntity();
        user.setId(userId);

        BookEntity book = new BookEntity();
        book.setTitle("Java basic");

        BookEntity book1 = new BookEntity();
        book1.setTitle("Spring");

        List<BookEntity>books = Arrays.asList(book,book1);

        Mockito.when(userRepo.getUser(userId)).thenReturn(user);
        Mockito.when(bookIssueRepo.getAllIssuedBooks(userId)).thenReturn(books);

        List<BookEntity> result = this.bookIssueService.getAllIssuedBooks(userId);

        Assertions.assertEquals(books,result);


    }
}
