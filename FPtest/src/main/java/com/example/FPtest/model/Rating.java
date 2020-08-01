
package com.example.FPtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Ratings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId", nullable = false, unique = true)
    private int ratingId;

    //    @Column(name = "comment_createdDate")
//    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "rating_createdDate")
    private String rating_createdDate;

    @Column(name = "value")
    private int value;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bookId", nullable = false)
    @JsonIgnore
    private Book book;

    //For Deserialization
    public Rating() {}

    public Rating(User user, int ratingId, String rating_createdDate, int value, Book book) {
        this.user = user;
        this.ratingId = ratingId;
        this.rating_createdDate = rating_createdDate;
        this.value = value;
        this.book = book;
    }

    public int getRatingId() {
        return ratingId;
    }

    public String getRating_createdDateCreatedDate() {
        return rating_createdDate;
    }

    public int getValue() {
        return value;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}








/*
package com.example.FPtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Ratings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ratingId", nullable = false, unique = true)
    private int ratingId;

//    @Column(name = "rating_createdDate")
//    private LocalDateTime rating_createdDate = LocalDateTime.now();
    @Column(name = "rating_createdDate")
    private String rating_createdDate;

    @Column(name = "value")
    private int value;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bookId", nullable = false)
    @JsonIgnore
    private Book book;

    //For Deserialization
    public Rating() {}

    public Rating(User user, int commentId, String rating_createdDate, String text, Book book) {
        this.user = user;
        this.ratingId = ratingId;
        this.rating_createdDate = rating_createdDate;
        this.value = value;
        this.book = book;
    }

    public int getRatingId() {
        return ratingId;
    }

    public String getRating_CreatedDate() {
        return rating_createdDate;
    }

    public int getVal() {
        return value;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public void setVal(int value) {
        this.value = value;
    }

}

 */




