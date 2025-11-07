package com.miniproject.digital_library.repository;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.repository.impl.BookRepo;
import com.miniproject.digital_library.repository.jpa.BookJpaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BookRepoTest {

    //the class which is tested
    @InjectMocks
    private BookRepo bookRepo;

    //the dependancy present in the class
    @Mock
    private BookJpaRepo bookJpaRepo;

    @Test
    void findBookById(){
        int id = 1;

        BookEntity book = BookEntity.builder()
                        .id(id)
                        .build();

        //the method which is dealing with db that method is associated with mockito
        // as it is not deals with db direcly we are just assuming this method & it will return whatever we want
        //jya method direcct db sobt connect krtatat tya method aapn mockito la deto
        Mockito.when(bookJpaRepo.findById(id)).thenReturn(Optional.of(book));

        //actual method of that funtion
        BookEntity book1 = bookRepo.findBookById(id);


        //book-->assumed value
        //book1-->actual value
        Assertions.assertEquals(book,book1);
    }
}
