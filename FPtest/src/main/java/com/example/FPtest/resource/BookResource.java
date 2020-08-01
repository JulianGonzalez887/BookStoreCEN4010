package com.example.FPtest.resource;

import com.example.FPtest.model.Book;
import com.example.FPtest.repository.BookRepository;
import exceptions.NotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/greektext/books")
public class BookResource {

    @Autowired
    BookRepository booksrepo;

    @GetMapping("/all")
    public List<Book> getAll() {
        return booksrepo.findAll();
    }

    @GetMapping("/isbn/{isbn}")
    public Book getById(@PathVariable Long isbn) {
        return booksrepo.findById(isbn).orElseThrow(() -> new NotFoundException("Book with ISBN " + isbn + " is not found!"));
    }

    @GetMapping(value = "/author/{author}")
    public List<Book> getByAuthor(@PathVariable String author) {
        return booksrepo.findByAuthor(author);
    }

    @PostMapping(value = "/create")
    public List<Book> persist(@RequestBody final Book book) {
        booksrepo.save(book);
        return booksrepo.findAll();
    }

    @PutMapping(value = "/update")
    public String update(@RequestBody final Book book) {
        booksrepo.save(book);
        return "Book with ISBN " + book.getIsbn() + " is updated!";
    }

    @DeleteMapping(value = "/delete/{isbn}")
    public String delete(@PathVariable Long isbn) {
        Optional<Book> book = booksrepo.findById(isbn);
        if(book.isPresent()) {
            booksrepo.delete(book.get());
            return "Book with ISBN " + isbn + " is deleted!";
        }
        else {
            throw new NotFoundException("Book with ISBN " + isbn + " does not exist!");
        }
    }
}

