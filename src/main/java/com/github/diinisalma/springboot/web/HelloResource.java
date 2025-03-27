package com.github.diinisalma.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.diinisalma.springboot.config.ApplicationProperties;

@RestController

// If you want to use @Controller, you need to add @ResponseBody to the return
// value of the method
// @Controller
// @ResponseBody
@RequestMapping("/v1/hello")
public class HelloResource {

    private final ApplicationProperties applicationProperties;

    // Use constructor injection for easier testing
    public HelloResource(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @GetMapping
    public String hello() {
        return "Hello World, " + applicationProperties.getName() + " " + applicationProperties.getCurrency();
    }

}
