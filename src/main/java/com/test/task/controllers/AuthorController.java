package com.test.task.controllers;

import com.test.task.dto.AuthorDto;
import com.test.task.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.test.task.data.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHORS)
public class AuthorController {


    private final AuthorService authorService;

    @GetMapping
    public List<AuthorDto> findAll() {
        return authorService.findAll();
    }

    @GetMapping(ID)
    public AuthorDto findById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @PostMapping
    public AuthorDto create(@RequestBody AuthorDto authorDto) {
        return authorService.create(authorDto);
    }
    @PutMapping(ID)
    public void update(@RequestBody AuthorDto authorDto){
        authorService.update(authorDto);
    }
    @DeleteMapping(ID)
    public void delete(@PathVariable Long id){
        authorService.delete(id);
    }
}
