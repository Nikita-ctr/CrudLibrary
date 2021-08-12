package com.spring.repository;

import com.spring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
   @Query (value = "SELECT b FROM Book b WHERE b.bookAuthor LIKE concat('%', :keyword, '%')"
            + " OR b.bookTitle LIKE concat('%', :keyword, '%')")
     List<Book> search(@Param("keyword") String keyword);


   @Query (value = "select sum(b.price*b.count) from Book b")
    Integer sumOfPrices();

    @Query (value = "select sum (b.count) from Book b")
    Integer booksCount();


}
