package com.test.task.service;

import com.test.task.dto.AuthorDto;
import com.test.task.dto.BookDto;
import com.test.task.entities.Author;
import com.test.task.entities.Book;
import com.test.task.repostories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookService bookService;
    private final ModelMapper modelMapper;
    public List<AuthorDto> findAll(){
        return authorRepository.findAll()
                .stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .collect(Collectors.toList());
    }

    public AuthorDto findById(Long id){
        return authorRepository.findById(id)
                .stream()
                .map(author -> modelMapper.map(author, AuthorDto.class))
                .findFirst()
                .orElse(null);
    }

    public void update(AuthorDto authorDto){
        authorDto.getBookList()
                .stream()
                .forEach(bookDto -> {
                    bookDto = bookService.findById(bookDto.getId());
                    bookDto.setAuthor(authorDto);
                });
        authorRepository.save(modelMapper.map(authorDto, Author.class));
    }

    public AuthorDto create(AuthorDto authorDto){
        Author author = modelMapper.map(authorDto, Author.class);
        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }
    public void delete(Long id){
        authorRepository.deleteById(id);
    }
}
