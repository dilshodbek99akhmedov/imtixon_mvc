package uz.pdp.mapper;

import org.springframework.stereotype.Controller;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookDto;
import uz.pdp.entity.Book;


@Controller
public class Mapper {

    public Book toEntity(BookCreateDto dto) {
        return new Book(dto.getName(), dto.getAuthor(), dto.getPage());
    }

    public BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(),book.getAuthor(),book.getPage());
    }
}
