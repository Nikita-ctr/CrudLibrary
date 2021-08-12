package com.spring.controllers;

import com.spring.models.Book;
import com.spring.service.BookService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml", "classpath:exampleApplicationContext-web.xml"})
@WebAppConfiguration
public class BookControllerTest{

    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        Mockito.reset(bookService);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();



    }
    @Test
    public void home() throws Exception {
        Book book1=new Book("title1","author1",2,100,new Date());
        Book book2=new Book("title2","author2",3,200,new Date());

        when(bookService.listAll()).thenReturn(Arrays.asList(book1,book2));
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(forwardedUrl("/WEB-INF/views/index.jsp"))
                .andExpect(model().attribute("bookList",hasSize(2)))
        .andExpect(model().attribute("sum",bookService.sumOfPrices()))
        .andExpect(model().attribute("count",bookService.countOfBooks()));
        verify(bookService,times(1)).listAll();

    }



    @Test
    public void newBookForm() throws Exception {
    mockMvc.perform(get("/new")).andExpect(status().isOk())
            .andDo(print())
            .andExpect(view().name("new_book"));

    }



    @Test
    public void saveBook() throws Exception {
        mockMvc.perform(post("/save")).andExpect(redirectedUrl("/"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/"));
    }

    @Test
    public void editBookForm() throws Exception {
        mockMvc.perform(get("/edit?id=3")).andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("edit_book"));
    }

    @Test
    public void deleteBookForm() throws Exception {
       mockMvc.perform(post("/delete?id=2")).andExpect(redirectedUrl("/"))
               .andExpect(status().isFound())
               .andExpect(view().name("redirect:/"));
    }

    @Test
    public void search() throws Exception {

        mockMvc.perform(get("/search?keyword=word")).andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("search"))
                .andExpect(model().attribute("result",bookService.search("word")));
    }
}
