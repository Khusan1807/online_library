package uz.pdp.dto.book;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateDto {

    private Long id;
    private String name;
    private String title;
    private String author;
    private Long price;

}
