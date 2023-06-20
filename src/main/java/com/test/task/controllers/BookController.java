package com.test.task.controllers;

import com.test.task.dto.BookDto;
import com.test.task.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.test.task.data.Constants.*;

@RestController
@RequestMapping(BOOKS)
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    @GetMapping
    public List<BookDto> findAll(){
        return bookService.findAll();
    }
    @GetMapping(ID)
    public BookDto findById(@PathVariable Long id){
        return bookService.findById(id);
    }
    @PostMapping
    public BookDto create(@RequestBody BookDto bookDto,  Long authorId){
        return bookService.create(bookDto, authorId);
    }
    @PutMapping(ID)
    public void update(@RequestBody BookDto bookDto,  Long authorId){
        bookService.update(bookDto,authorId);
    }
    @DeleteMapping(ID)
    public void delete(@PathVariable Long id){
        bookService.delete(id);
    }
}
