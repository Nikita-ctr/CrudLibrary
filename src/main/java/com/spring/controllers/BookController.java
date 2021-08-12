package com.spring.controllers;

import com.spring.models.Book;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView home() {
        List<Book> bookList = bookService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("bookList", bookList);
        mav.addObject("sum",bookService.sumOfPrices());
        mav.addObject("count",bookService.countOfBooks());
        return mav;
    }


    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String newBookForm(Map<String, Object> model) {
        Book book = new Book();
        model.put("book", book);
        return "new_book";
    }
    @RequestMapping (value = "/save", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.save(book);
        return "redirect:/";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public ModelAndView editBookForm(@RequestParam int id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = bookService.get(id);
        mav.addObject("book", book);
        return mav;
    }
    @RequestMapping(value = "/delete")
    public String deleteBookForm(@RequestParam int id) {
        bookService.delete(id);
        return "redirect:/";
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public ModelAndView search(@RequestParam String keyword) {
        List<Book> result = bookService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }


}
