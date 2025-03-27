package com.github.diinisalma.springboot.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.diinisalma.springboot.Author;
import com.github.diinisalma.springboot.Book;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

@Configuration
public class AppConfig {
    @Bean
    public Author author1() {
        Author author = new Author();
        author.setName("John Doe");
        return author;
    }

    @Bean
    public Book book1(Author author1) {
        Book book = new Book(author1);
        book.setTitle("Spring in Action");
        return book;
    }

    @Bean
    public Properties properties() {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        properties.put("mail.smtp.port", "2525");
        properties.put("mail.smtp.ssl.trust", "sandbox.smtp.mailtrap.io");
        return properties;
    }

    @Bean
    public Session mailSession(@Qualifier("properties") Properties properties,
            @Qualifier("mailAuthenticator") Authenticator authenticator) {

        return Session.getInstance(properties, authenticator);
    }

    @Bean
    public Authenticator mailAuthenticator(PasswordAuthentication passwordAuthentication) {
        return new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(passwordAuthentication.getUserName(),
                        passwordAuthentication.getPassword());
            }
        };
    }

    @Bean
    public PasswordAuthentication passwordAuthentication() {
        return new PasswordAuthentication("13b27cfe71dbf5", "7fbcb73ad555ab");
    }

}
