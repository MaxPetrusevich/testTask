package com.test.task.service;

import com.test.task.dto.AuthorDto;
import com.test.task.dto.BookDto;
import com.test.task.entities.Author;
import com.test.task.entities.Book;
import com.test.task.repostories.AuthorRepository;
import com.test.task.repostories.BookRepository;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;
    public BookDto create(BookDto bookDto, Long authorId){
        Book book = modelMapper.map(bookDto, Book.class);
        book.setAuthor(authorRepository.findById(authorId).orElse(null));
        book.getAuthor().setBooksCount(book.getAuthor().getBooksCount() + 1);
        book = bookRepository.save(book);
        return modelMapper.map(book, BookDto.class);
    }
    public List<BookDto> findAll(){
        return bookRepository.findAll()
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }
    public BookDto findById(Long id){
        return bookRepository.findById(id)
                .stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .findFirst()
                .orElse(null);
    }
    public void update(BookDto bookDto, Long authorId){
        Author author =authorRepository.findById(authorId).orElse(null);
        if(bookDto.getAuthor().getId() != authorId){
            author.setBooksCount(author.getBooksCount() + 1);
            bookDto.getAuthor().setBooksCount(bookDto.getAuthor().getBooksCount() - 1);
        }
        bookDto.setAuthor(modelMapper.map(author, AuthorDto.class));
        bookRepository.save(modelMapper.map(bookDto, Book.class));
    }
    public void delete(Long id){
        bookRepository.deleteById(id);
    }
}
