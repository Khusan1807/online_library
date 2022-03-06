package uz.pdp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.dto.book.BookCreateDto;
import uz.pdp.dto.book.BookDto;
import uz.pdp.dto.book.BookUpdateDto;
import uz.pdp.entity.Book;
import uz.pdp.mapper.BookMapper;
import uz.pdp.repository.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookMapper mapper;
    private final BookRepository repository;


    public void create(BookCreateDto dto) {
        Book book = mapper.fromCreateDto(dto);
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        book.setTitle(dto.getTitle());
        book.setPrice(dto.getPrice());
        repository.save(book);
    }

    public BookDto get(Long id) {
        return mapper.toDto(repository.findById(id).get());
    }


    public List<BookDto> getAll() {
        return mapper.toDto(repository.findAll());
    }


    public void update(BookUpdateDto updateDto) {
        Book book = mapper.fromUpdateDto(repository.findById(updateDto.getId()).get());
        book.setName(updateDto.getName());
        book.setAuthor(updateDto.getAuthor());
        book.setTitle(updateDto.getTitle());
        book.setPrice(updateDto.getPrice());
        book.setId(updateDto.getId());
        repository.save(book);

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
