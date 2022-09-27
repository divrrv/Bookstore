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

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("Testi kirjat");
			Category category1 = new Category("scifi");
			crepository.save(category1);
			Category category2 = new Category("comic");
			crepository.save(category2);
			Category category3 = new Category("novel");
			crepository.save(category3);
			
			brepository.save( new Book("Joulu", "Louis D", 1996, "121223", 12.30));
			brepository.save( new Book("Kesä", "Sini H", 1998, "131321", 12.30));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
				
		};
	}

}
