package uz.pdp.mapper;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookDto;
import uz.pdp.entity.Book;

import java.util.List;

@Mapper(componentModel = "spring")
@Component(value = "bookMapper")
public interface BookMapper {

    List<BookDto> toDto(List<Book> book);
    BookDto toDto(Book book);


    Book fromCreateDto(BookCreateDto dto);


    Book fromUpdateDto(Book bookUpdateDto);
}
