package com.miniproject.digital_library.repository.jpa;

import com.miniproject.digital_library.entity.BookEntity;
import com.miniproject.digital_library.entity.BookIssueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface BookIssueJpaRepo extends JpaRepository<BookIssueEntity,Integer> {

    @Query("""
       SELECT COUNT(b)
       FROM BookIssueEntity b
       WHERE b.userEntity.id = :userId
       """)
    int  countIssuedBooksByUser(@Param("userId") int userId);



    @Query("""
       SELECT b.bookEntity
       FROM BookIssueEntity b
       WHERE b.userEntity.id = :userId
       """)
    List<BookEntity> getAllIssuedBooks(@Param("userId") int userId);


//    @Query("""
//       SELECT b.bookEntity COUNT(b.bookEntity)
//       FROM BookIssueEntity b
//       GROUP BY b.bookEntity
//       ORDER BY COUNT(b.bookEntity) DESC
//       LIMIT 5
//       """)
//    List<Object[]> findMostIssuedBooks();






}
