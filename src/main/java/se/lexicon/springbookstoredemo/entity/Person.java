package se.lexicon.springbookstoredemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Entity //JPA, marks this as a database entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int person_id;
    @Column(nullable = false, length = 50)
    private String first_name;
    @Column(nullable = false, length = 50)
    private String last_name;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    private LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Book> books;

    @PrePersist
    public void onCreate(){
        this.createDate = LocalDateTime.now();
    }

    public Person(String first_name, String last_name, String email, LocalDateTime createDate) {
        this(first_name, last_name, email);
        this.createDate = createDate;
    }

    public Person(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
    }

    public void addBook(Book book) {
        books.add(book);
        book.setPerson(this);
    }
    public void removeBook(Book book) {
        book.setPerson(null);
        books.remove(book);
    }
}
