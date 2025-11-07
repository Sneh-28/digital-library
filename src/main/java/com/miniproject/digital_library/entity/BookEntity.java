package com.miniproject.digital_library.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "author",nullable = false)
    private String author;

    @Column(unique = true,nullable = false)
    private String isbn;

    @Column(name = "publishedYear",nullable = false)
    private int publishedYear;

    @Column(name = "price",nullable = false)
    private int price;
}
