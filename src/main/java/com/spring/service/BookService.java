package com.spring.service;

import com.spring.models.Book;
import com.spring.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void save(Book book) {
        bookRepository.save(book);
    }

    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    public Book get(int id) {
        return bookRepository.findById(id).get();
    }

    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> search(String keyword) {
        return bookRepository.search(keyword);
    }

    public Integer sumOfPrices(){
        return bookRepository.sumOfPrice();
    }
    public Integer countOfBooks(){
        return bookRepository.booksCount();
    }


}
