package uz.pdp.dto.book;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BookCreateDto {
    private String name;
    private String author;
    private Integer page;
}
