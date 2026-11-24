package mate.academy.bookstore;

import java.math.BigDecimal;
import mate.academy.bookstore.model.Book;
import mate.academy.bookstore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BookService bookService) {
        return args -> {
            Book book = new Book();
            book.setTitle("Clean Code");
            book.setAuthor("Robert C. Martin");
            book.setIsbn("9780132350884");
            book.setPrice(new BigDecimal("450.00"));
            book.setDescription("A book about writing clean and maintainable code.");
            book.setCoverImage("https://example.com/clean-code.jpg");

            bookService.save(book);

            bookService.findAll().forEach(System.out::println);
        };
    }
}
