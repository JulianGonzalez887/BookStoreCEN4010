
package com.example.FPtest.repository;

import com.example.FPtest.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long>{

    List<Book> findByAuthor(String author);

}
