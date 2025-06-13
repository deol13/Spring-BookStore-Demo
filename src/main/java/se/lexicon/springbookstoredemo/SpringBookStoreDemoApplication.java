package se.lexicon.springbookstoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.springbookstoredemo.repository.BookRepository;
import se.lexicon.springbookstoredemo.repository.PersonRepository;

@SpringBootApplication
public class SpringBookStoreDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookStoreDemoApplication.class, args);

    }

}
