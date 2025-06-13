package se.lexicon.springbookstoredemo.entity;

import jakarta.persistence.*;
import lombok.*;

// Lombok
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity //JPA, marks this as a database entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY = AUTO_INCREMENT
    private int book_id;
    @Column(nullable = false, length = 50)
    private String book_Title;
    @Column(nullable = false, length = 50)
    private String book_Author;
    @Column(nullable = false)
    private String book_Year;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    public Book(String book_Title, String book_Author, String book_Year) {
        this.book_Title = book_Title;
        this.book_Author = book_Author;
        this.book_Year = book_Year;
    }
}
