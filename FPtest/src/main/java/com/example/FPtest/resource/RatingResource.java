package com.example.FPtest.resource;



import com.example.FPtest.model.Rating;

import com.example.FPtest.repository.BookRepository;
import com.example.FPtest.repository.UserRepository;
import com.example.FPtest.repository.RatingRepository;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/geektext")
public class RatingResource {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    //Displays List of All Ratings on Database
    @GetMapping("/ratings/all")
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    //Finds ratings by a user
    @GetMapping("/ratings/users/{username}")
    public List<Rating> getRatingByUsername(@PathVariable String username) throws NotFoundException {
        if (userRepository.findById(username).isEmpty()) {
            throw new NotFoundException("User '" + username + "' not found");
        }
        return ratingRepository.findByUser(userRepository.findById(username).get());
    }

    //Finds ratings by a book isbn
    @GetMapping("/ratings/books/{isbn}")
    public List<Rating> getRatingByIsbn(@PathVariable Long isbn) throws NotFoundException {
        if (bookRepository.findById(isbn).isEmpty()) {
            throw new NotFoundException("book '" + isbn + "' not found");
        }
        return ratingRepository.findByBook(bookRepository.findById(isbn).get());
    }
}
















