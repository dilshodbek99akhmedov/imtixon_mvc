package uz.pdp.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@Entity(name = "books")
@Table(name = "books")
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private Integer page;
    private Boolean deleted;

    public Book(String name, String author, Integer page) {
        this.name = name;
        this.author = author;
        this.page = page;
        this.deleted = false;
    }
}