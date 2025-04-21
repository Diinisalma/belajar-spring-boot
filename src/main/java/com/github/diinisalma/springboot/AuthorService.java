package com.github.diinisalma.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final List<AuthorDTO> authors = new ArrayList<>();

    public void save(AuthorDTO authorDTO) {
        authors.add(authorDTO);
    }

    public List<AuthorDTO> findAll() {
        return authors;
    }

}
