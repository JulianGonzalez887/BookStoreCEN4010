package com.example.FPtest.resource;

import com.example.FPtest.model.Book;
import com.example.FPtest.model.User;

import com.example.FPtest.model.Comment;

import com.example.FPtest.repository.BookRepository;
import com.example.FPtest.repository.CommentRepository;
import com.example.FPtest.repository.UserRepository;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geektext")
public class CommentResource {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    //Displays List of All Comments on Database
    @GetMapping("/comments/all")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @GetMapping("/comments/users/{username}")
    public List<Comment> getCommentsByUsername(@PathVariable String username) throws NotFoundException {
        if (userRepository.findById(username).isEmpty()) {
            throw new NotFoundException("User '" + username + "' not found");
        }
        return commentRepository.findByUser(userRepository.findById(username).get());
    }

    @GetMapping("/comments/books/{isbn}")
    public List<Comment> getCommentsByIsbn(@PathVariable Long isbn) throws NotFoundException {
        if (bookRepository.findById(isbn).isEmpty()) {
            throw new NotFoundException("book '" + isbn + "' not found");
        }
        return commentRepository.findByBook(bookRepository.findById(isbn).get());
    }

    //Creates a New Comment
//    @PostMapping("/comments/{username}/{book_id}")
//    public Comment newComment(@PathVariable String username, Long book_id, @RequestBody Comment newComment) throws NotFoundException {
//
//        if (commentRepository.findById(username).isEmpty()) {
//            throw new NotFoundException("User '" + username + "' not found");
//        }
//        if (commentRepository.findByBook(book_id).isEmpty()) {
//            throw new NotFoundException("User '" + username + "' not found");
//        }

//        User user = UserRepository.findById(username).get();
//        user.getCreditCard().add(creditCard);
//        creditCard.setUser(userRepository.findById(username).get());
//        userRepository.save(user);
//        return cardsRepository.save(creditCard);

//        return commentRepository.save(newComment);
//    }


//    @PostMapping(value = "/comment/create")
//    public List<Comment> persist(@RequestBody final Comment comment) {
//        commentRepository.save(comment);
//        return commentRepository.findAll();
//    }


    //Creates a New Comment
    @PostMapping("/users/{username}/{bookId}")
    public Comment newComment(@RequestBody Comment comment, @PathVariable String username, @PathVariable Long bookId) throws NotFoundException {
        if (userRepository.findById(username).isEmpty()) {
            throw new NotFoundException("User '" + username + "' not found");
        }
        /*
        Book book = new Book();
        if (!bookRepository.findById(book.bookRepository.findById(isbn)).isEmpty()) {
            throw new NotFoundException("Credit Card '" + creditCard.getCardNumber() + "' already on File");
        }

         */
        User user = userRepository.findById(username).get();
        user.getComments().add(comment);
        comment.setUser(userRepository.findById(username).get());
        Book book = bookRepository.findById(bookId).get();
        book.getComments().add(comment);
        comment.setBook(bookRepository.findById(bookId).get());
        bookRepository.save(book);
        userRepository.save(user);
        return commentRepository.save(comment);
    }



}


/*
package com.example.FPtest.resource;

import com.example.FPtest.model.Book;
import com.example.FPtest.model.User;
//import com.example.FPtest.model.CreditCard;
import com.example.FPtest.model.Comment;
//import com.example.FPtest.repository.CreditCardRepository;
import com.example.FPtest.repository.BookRepository;
import com.example.FPtest.repository.CommentRepository;
import com.example.FPtest.repository.UserRepository;
import exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/geektext")
public class CommentResource {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BookRepository bookRepository;

    //Displays List of All Comments on Database
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    //Creates a New Comment
    @PostMapping("/comments")
    public Comment newComment(@RequestBody Comment newComment) {
        return commentRepository.save(newComment);
    }



    //Displays Comments By Username Search
//    @GetMapping("/comments/{comment_username}")
//    public Comment findCommentByUsername(@PathVariable String username) {
//        Optional<Comment> comment = commentRepository.findById(username);
//        if (comment.isPresent()) {
//            return comment.get();
//        } else{
//            throw new RuntimeException("Comment '" + username + "' not found");
//        }
//    }

//    @GetMapping("/comments/book/{book_id}")
//    public List<Comment> findCommentByIsbn(@PathVariable Long book_id) {
//        return commentRepository.findByBook(book_id);
//    }

//    @GetMapping("/comments/book/{book_id}")
//    public List<Comment> findCommentByIsbn(@PathVariable Long book_id) throws NotFoundException {
//        if (commentRepository.findByBook(book_id).isEmpty()){
//            throw new NotFoundException("User '" + book_id + "' not found");
//        }
//        return (List<Comment>) commentRepository.findByBook(book_id).get();
//    }

    //Displays Comments By isbn Search
//    @GetMapping("/comments/book/{book_id}")
//    public Comment findCommentByIsbn(@PathVariable Long book_id) {
//        Optional<Comment> comment = commentRepository.findByBook(book_id);
//        if (comment.isPresent()) {
//            return comment.get();
//        } else{
//            throw new RuntimeException("Comment '" + book_id + "' not found");
//        }
//    }



//    @RequestMapping(value="/wallets", method=RequestMethod.POST)
//    public Comment save(@RequestBody Comment comment) {
//        return commentRepository.save(comment);
//    }



}

 */






