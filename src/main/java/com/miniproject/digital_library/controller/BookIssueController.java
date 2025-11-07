package com.miniproject.digital_library.controller;

import com.miniproject.digital_library.dto.BookIssueDto;
import com.miniproject.digital_library.dto_mapper.BookIssueDtoMapper;
import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.BookIssueEntity;
import com.miniproject.digital_library.service.BookIssueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/book_issue")
public class BookIssueController {

    private final BookIssueDtoMapper bookIssueDtoMapper;
    private final BookIssueService bookIssueService;

    public BookIssueController(BookIssueDtoMapper bookIssueDtoMapper,BookIssueService bookIssueService) {
        this.bookIssueDtoMapper = bookIssueDtoMapper;
        this.bookIssueService = bookIssueService;
    }

    @PostMapping  //issuing books
    public ResponseEntity<BookIssueEntity> issueBook(@RequestBody BookIssueDto bookIssueDto){
        BookIssueEntity bookIssueEntity = this.bookIssueDtoMapper.toEntity(bookIssueDto);
        BookIssueEntity bookIssueEntity1 = this.bookIssueService.addIssueBook(bookIssueEntity);
        return new ResponseEntity<>(bookIssueEntity1, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public List<BookEntity> getAllIssuedBooks(@PathVariable int userId){
       return this.bookIssueService.getAllIssuedBooks(userId);
    }
}
