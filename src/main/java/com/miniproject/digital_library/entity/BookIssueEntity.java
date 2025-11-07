package com.miniproject.digital_library.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BookIssue")
public class BookIssueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "book_entity_id")
    private BookEntity bookEntity;

    @Column(name = "startDate",nullable = false)
    private LocalDate startDate = LocalDate.now();

    @Column(name = "expireDate",nullable = false)
    private LocalDate expireDate;
}
