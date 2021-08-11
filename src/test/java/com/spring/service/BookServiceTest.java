package com.spring.service;
import com.spring.models.Book;
import com.spring.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

   @Mock
   BookRepository bookRepository;

   @InjectMocks
   BookService bookService;



    @Test
    public void save() {
        Book book=new Book("title1","author1",2,100,new Date());
        bookRepository.save(book);
        assertNotNull(book);
        assertEquals("author1", book.getBookAuthor());
    }

    @Test
    public void listAll() {
        Book book=new Book("title","author",2,100,new Date());
        Mockito.when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));

        List<Book> bookList=bookService.listAll();
        assertNotNull(bookList);
        Assert.assertTrue(bookList.size()>0);


    }

    @Test
    public void get() {
        Book book=new Book();
        book.setId(1);
        Assert.assertTrue(book.getId()>0);
    }

    @Test
    public void delete() {
    Book book=new Book();
    book.setBookTitle("Title");
    book.setId(1);
        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book));
    bookService.delete(book.getId());
    verify(bookRepository).deleteById(book.getId());



    }

}