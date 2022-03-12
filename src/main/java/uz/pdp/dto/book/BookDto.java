package uz.pdp.dto.book;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class BookDto {
    public Long id;
    public String name;
    public String author;
    public Integer page;
}
