package com.github.diinisalma.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.diinisalma.springboot.AuthorDTO;
import com.github.diinisalma.springboot.service.impl.AuthorServiceImpl;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping("new")
    public String loadAuthorForm(Model model) {
        model.addAttribute("authorDTO", new AuthorDTO("", ""));
        model.addAttribute("title", "Add New Author");
        return "authors/author-new";
    }

    @PostMapping("new")
    public String submitAuthor(@ModelAttribute AuthorDTO dto) {
        authorService.save(dto);
        return "redirect:/authors";
    }

    @GetMapping("result")
    public String resultAuthor(@ModelAttribute AuthorDTO dto) {

        return "authors/author-result";
    }

    @GetMapping()
    public String getAuthors(Model model) {
        model.addAttribute("title", "Authors");
        model.addAttribute("authors", authorService.findAll());
        return "authors/author-list";
    }

}
