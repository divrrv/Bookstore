package hh.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.Bookstore.domain.Category;
import hh.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value = "/categorylist", method = RequestMethod.GET)
	public String categoryList (Model model) {
		model.addAttribute("categorys", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/savec", method = RequestMethod.POST)
    public String save(Category category){
        crepository.save(category);
        return "redirect:categorylist";
    }
	
	@RequestMapping(value = "/addc", method = RequestMethod.GET)
	public String addCategory (Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	
}
