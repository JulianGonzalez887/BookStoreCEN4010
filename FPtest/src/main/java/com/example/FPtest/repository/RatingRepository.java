package com.example.FPtest.repository;


import com.example.FPtest.model.Book;
import com.example.FPtest.model.Comment;
import com.example.FPtest.model.Rating;
import com.example.FPtest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findByBook(Book BookId);

    List<Rating> findByUser(User user);

    //Optional <Comment> findByBook(Long id);
}


