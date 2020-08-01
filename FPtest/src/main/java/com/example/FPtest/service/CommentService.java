//
//package com.example.FPtest.service;
//
//import com.example.FPtest.model.Book;
//import com.example.FPtest.model.Comment;
//import com.example.FPtest.model.Rating;
//import com.example.FPtest.repository.BookRepository;
//import com.example.FPtest.repository.CommentRepository;
//import com.example.FPtest.repository.RatingRepository;
//import com.example.FPtest.repository.UserRepository;
//import com.example.FPtest.resource.CommentResource;
//import exceptions.NotFoundException;
//
//public class CommentService {
//
//    private final BookRepository bookRepository;
//    private final UserRepository userRepository;
//    private final CommentResource commentResource;
//    private final CommentRepository commentRepository;
//    private final RatingRepository ratingRepository;
//    private Comment comment;
//
//    public CommentService(BookRepository bookRepository, UserRepository userRepository, CommentResource commentResource, CommentRepository commentRepository) {
//        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
//        this.commentResource = commentResource;
//        this.commentRepository = commentRepository;
//    }
//
//    public Object getAllRatingsForBook(Long isbn) {
//        Rating rating = ratingRepository.findByBook(isbn);
//
//    }
//}
//
//
//
//
