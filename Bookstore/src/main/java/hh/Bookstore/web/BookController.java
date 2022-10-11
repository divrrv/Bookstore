package hh.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.Bookstore.domain.Book;
import hh.Bookstore.domain.BookRepository;
import hh.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private BookRepository brepository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList (Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	// RESTful     Get all books
		@RequestMapping(value = "/books", method = RequestMethod.GET)
		public @ResponseBody List<Book> bookListRest() {
			return (List<Book>) brepository.findAll();
		}
		
	// RESTful     Get book by id
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return brepository.findById(bookId);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    
	
	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteBook (@PathVariable("id") Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	

}
