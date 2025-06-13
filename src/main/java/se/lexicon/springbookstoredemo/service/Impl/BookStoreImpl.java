package se.lexicon.springbookstoredemo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.springbookstoredemo.entity.Book;
import se.lexicon.springbookstoredemo.entity.Person;
import se.lexicon.springbookstoredemo.repository.BookRepository;
import se.lexicon.springbookstoredemo.repository.PersonRepository;
import se.lexicon.springbookstoredemo.service.BookStore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookStoreImpl implements BookStore {
    private BookRepository bookRepository;
    private PersonRepository personRepository;

    @Autowired
    public BookStoreImpl(BookRepository bookRepository, PersonRepository personRepository) {
        this.bookRepository = bookRepository;
        this.personRepository = personRepository;
    }

    // ------------------------------------------------------- Book

    @Override
    public Book createBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        return bookRepository.save(book);
    }

    @Override
    public Book findBook(int book_id) {
        return bookRepository.findById(book_id).orElse(null);
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        for (Book book : bookRepository.findAll()) {
            books.add(book);
        }
        return books;
    }

    @Override
    public void deleteBook(int book_id) {
        bookRepository.deleteById(book_id);
    }

    @Override
    public Book updateBook(Book book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null");
        return bookRepository.save(book);
    }

    // ------------------------------------------------------- Person

    @Override
    public Person createPerson(Person person) {
        if (person == null) throw new IllegalArgumentException("Person cannot be null");
        return personRepository.save(person);
    }

    @Override
    public Person findPerson(int person_id) {
        return personRepository.findById(person_id).orElse(null);
    }

    @Override
    public List<Person> findAllPersons() {
        List<Person> books = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            books.add(person);
        }
        return books;
    }

    @Override
    public void deletePerson(int person_id) {
        if (person_id == 0) throw new IllegalArgumentException("Person cannot be null");
        personRepository.deleteById(person_id);
    }

    @Override
    public Person updatePerson(Person person) {
        if (person == null) throw new IllegalArgumentException("Person cannot be null");
        return personRepository.save(person);
    }

    // ------------------------------------------------------- Borrow

    @Override
    public void borrowBook(Book book, Person person) {
        if(person.getBooks().contains(book)) throw new IllegalArgumentException("Person is already borrowed that book: " + book.getBook_Title());
        person.addBook(book);
    }

    @Override
    public void returnBook(Book book, Person person) {
        if(!person.getBooks().contains(book)) throw new IllegalArgumentException("Person is not borrowing that book: " + book.getBook_Title());
        person.removeBook(book);
    }
}
