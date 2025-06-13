package se.lexicon.springbookstoredemo.service;

import se.lexicon.springbookstoredemo.entity.Book;
import se.lexicon.springbookstoredemo.entity.Person;

import java.util.List;

public interface BookStore {
    Book createBook(Book book);
    Book findBook(int book_id);
    List<Book> findAllBooks();
    void deleteBook(int book_id);
    Book updateBook(Book book);

    Person createPerson(Person person);
    Person findPerson(int person_id);
    List<Person> findAllPersons();
    void deletePerson(int person_id);
    Person updatePerson(Person person);

    void borrowBook(Book book, Person person);
    void returnBook(Book book, Person person);
}
