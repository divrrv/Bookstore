package hh.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.Bookstore.domain.Category;
import hh.Bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categorys = crepository.findByName("scifi");
        
        assertThat(categorys).hasSize(1);
        assertThat(categorys.get(0).getName()).isEqualTo("scifi");
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("testi");
		crepository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
	} 
	
	@Test
	public void deleteCategory() {
		crepository.delete(crepository.findByName("scifi").get(0));
        List<Category> categorys = crepository.findByName("scifi");
        assertThat(categorys).hasSize(0);	
	}

}
