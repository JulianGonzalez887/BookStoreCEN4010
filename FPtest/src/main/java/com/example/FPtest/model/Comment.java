
package com.example.FPtest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Comments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId", nullable = false, unique = true)
    private int commentId;

//    @Column(name = "comment_createdDate")
//    private LocalDateTime createdDate = LocalDateTime.now();
    @Column(name = "comment_createdDate")
    private String createdDate;

    @Column(name = "comment_text")
    private String text;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId",referencedColumnName = "username", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "bookId", referencedColumnName = "isbn", nullable = false)
    @JsonIgnore
    private Book book;

    //For Deserialization
    public Comment() {}

    public Comment(User user, int commentId, String CreatedDate, String text, Book book) {
        this.user = user;
        this.commentId = commentId;
        this.createdDate = CreatedDate;
        this.text = text;
        this.book = book;
    }

    public int getCommentId() {
        return commentId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public String getText() {
        return text;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setText(String text) {
        this.text = text;
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
