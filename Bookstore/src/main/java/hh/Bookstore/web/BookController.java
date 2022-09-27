package hh.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.Bookstore.domain.Book;
import hh.Bookstore.domain.BookRepository;
import hh.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private BookRepository brepository;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getBook(Model model) {
		return "index";
	}
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookList (Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook (Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }    
	
	@RequestMapping(value = "/delete{id}", method = RequestMethod.GET)
	public String deleteBook (@PathVariable("id") Long bookId, Model model) {
		brepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	

}
