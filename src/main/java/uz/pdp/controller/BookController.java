package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookUpdateDto;
import uz.pdp.entity.Book;
import uz.pdp.service.BookService;

import java.util.List;


@Controller
@RequestMapping("/book/")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage() {
        return "books/bookCreate";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@ModelAttribute BookCreateDto dto) {
        service.create(dto);
        return "adminCabinet";
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String bookList(Model model) {
         List<Book> books=  service.bookList();
        model.addAttribute("books", books);
        return "books/bookList";
    }
    @RequestMapping(value = "delete/{book_id}")
    public String delete(@PathVariable(name = "book_id") Long id){
        service.delete(id);
        return "redirect:/book/list";
    }
    @RequestMapping(value = "update/{book_id}", method = RequestMethod.GET)
    public String updatePage(@PathVariable(name = "book_id") Long id , Model model){
        model.addAttribute("book", service.get(id));
        return "books/bookUpdate";
    }
    @RequestMapping(value = "update/{book_id}", method = RequestMethod.POST)
    public String update(@PathVariable(name = "book_id")Long id , @ModelAttribute BookUpdateDto dto){
        dto.setId(id);
        service.update( dto);
        return "redirect:/book/list";
    }
}
