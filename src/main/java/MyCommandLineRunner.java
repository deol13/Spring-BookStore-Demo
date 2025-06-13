import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springbookstoredemo.service.BookStore;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    BookStore bookStore;

    @Autowired
    public MyCommandLineRunner(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
