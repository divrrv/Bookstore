package hh.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.Bookstore.domain.Book;
import hh.Bookstore.domain.BookRepository;
import hh.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
	private BookRepository brepository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("Joulu");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Louis D");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Syksy", "Louis D", 1996, "121224", 12.30, crepository.findByName("scifi").get(0));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	} 
	
	@Test
	public void deleteBook() {
		brepository.delete(brepository.findByTitle("Joulu").get(0));
		List<Book> books = brepository.findByTitle("Joulu");
		assertThat(books).hasSize(0);
	}

}
