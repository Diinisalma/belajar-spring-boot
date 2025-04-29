package com.github.diinisalma.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.diinisalma.springboot.AuthorDTO;
import com.github.diinisalma.springboot.domain.AuthorEntity;
import com.github.diinisalma.springboot.domain.AuthorRepository;
import com.github.diinisalma.springboot.service.AuthorService;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final List<AuthorDTO> authors = new ArrayList<>();

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void save(AuthorDTO authorDTO) {
       authorRepository.save(new AuthorEntity(authorDTO.name(), authorDTO.description()));
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorEntity> result = authorRepository.findAll();
        return result.stream().map(a -> new AuthorDTO(a.getName(), a.getDescription())).toList();
    }

    @Override
    public Optional<AuthorDTO> findById(Long id) {
        AuthorEntity entity = authorRepository.findById(id).orElseThrow();
        return null;
    }

    @Override
    public void update(Long id, AuthorDTO authorDTO) {

    }

    @Override
    public void delete(Long id) {

    }

}
