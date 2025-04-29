package com.github.diinisalma.springboot.service;

import com.github.diinisalma.springboot.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void save(AuthorDTO authorDTO);
    List<AuthorDTO> findAll();
    Optional<AuthorDTO> findById(Long id);
    void update(Long id, AuthorDTO authorDTO);
    void delete(Long id);
}
