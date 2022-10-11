package hh.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.Bookstore.domain.Book;
import hh.Bookstore.domain.BookRepository;
import hh.Bookstore.domain.Category;
import hh.Bookstore.domain.CategoryRepository;
import hh.Bookstore.domain.User;
import hh.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("Testi kirjat");
			Category category1 = new Category("scifi");
			crepository.save(category1);
			Category category2 = new Category("comic");
			crepository.save(category2);
			Category category3 = new Category("novel");
			crepository.save(category3);
			
			brepository.save( new Book("Joulu", "Louis D", 1996, "121223", 12.30, category3));
			brepository.save( new Book("Kesä", "Sini H", 1998, "131321", 12.30, category3));
			
			User user1 = new User("user", "$2a$10$OI7t3nowBhrQrQ51E5qIEuo9pC9NVa5oi6XKiE2XZcayA677ldr9a", "USER");
			User user2 = new User("admin", "$2a$10$b81RbL6hNpOMc6KuNdypqOlilTVorqSX.FSnxpElY3YMeWKcMwB7e", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
				
		};
	}

}
