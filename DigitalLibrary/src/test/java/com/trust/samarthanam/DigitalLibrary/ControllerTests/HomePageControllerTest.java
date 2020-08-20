package com.trust.samarthanam.DigitalLibrary.ControllerTests;


import com.trust.samarthanam.DigitalLibrary.Controller.HomePageController;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.Service.HomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HomePageController.class)
public class HomePageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeService homeService;

    @Test
    public void findBookByLanguageTest() throws Exception{
        Books books = new Books();
        List<Books> book = new ArrayList<>();

        Format f = new Format();
        f.setType("Audio");
        f.setUrl("https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E");
        Format g = new Format();
        g.setType("PDF");
        g.setUrl("null");
        List<Format> format = new ArrayList<>();
        format.add(f);
        format.add(g);

        List<String> category = new ArrayList<>();
        category.add("Textbooks");

        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");

        books.setId(1);
        books.setName("Astronomy");
        books.setIsbn("996-56-045-61");
        books.setAuthor("Alain.J.Brizard");
        books.setFormat(format);
        books.setLanguage("English");
        books.setBookImage("https://drive.google.com/uc?export=view&id=1sbhabVfpYDthUX-x6_4X1X_hYLl3jEKs");
        books.setDescription("Physics Atronomy textbook");
        books.setViews(3);
        books.setCategory(category);
        books.setSubCategory(sc);
        books.setRating(5);

        book.add(books);

//        System.out.println(book);
        when(homeService.findBooksByLanguage("English")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/language/English")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void findBookByCategoryTest() throws Exception{
        Books books = new Books();
        List<Books> book = new ArrayList<>();

        Format f = new Format();
        f.setType("Audio");
        f.setUrl("https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E");
        Format g = new Format();
        g.setType("PDF");
        g.setUrl("null");
        List<Format> format = new ArrayList<>();
        format.add(f);
        format.add(g);

        List<String> category = new ArrayList<>();
        category.add("Textbooks");

        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");

        books.setId(1);
        books.setName("Astronomy");
        books.setIsbn("996-56-045-61");
        books.setAuthor("Alain.J.Brizard");
        books.setFormat(format);
        books.setLanguage("English");
        books.setBookImage("https://drive.google.com/uc?export=view&id=1sbhabVfpYDthUX-x6_4X1X_hYLl3jEKs");
        books.setDescription("Physics Atronomy textbook");
        books.setViews(3);
        books.setCategory(category);
        books.setSubCategory(sc);
        books.setRating(5);

        book.add(books);

//        System.out.println(book);
        when(homeService.findBooksByCategory("Textbooks")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/category/Textbooks")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void recentlyAddedTest() throws Exception{
        Books books = new Books();
        List<Books> book = new ArrayList<>();

        Format f = new Format();
        f.setType("Audio");
        f.setUrl("https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E");
        Format g = new Format();
        g.setType("PDF");
        g.setUrl("null");
        List<Format> format = new ArrayList<>();
        format.add(f);
        format.add(g);

        List<String> category = new ArrayList<>();
        category.add("Textbooks");

        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");

        books.setId(1);
        books.setName("Astronomy");
        books.setIsbn("996-56-045-61");
        books.setAuthor("Alain.J.Brizard");
        books.setFormat(format);
        books.setLanguage("English");
        books.setBookImage("https://drive.google.com/uc?export=view&id=1sbhabVfpYDthUX-x6_4X1X_hYLl3jEKs");
        books.setDescription("Physics Atronomy textbook");
        books.setViews(3);
        books.setCategory(category);
        books.setSubCategory(sc);
        books.setRating(5);

        book.add(books);

//        System.out.println(book);
        when(homeService.findRecentlyAddedBooks()).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/recentlyadded")).andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void mostViewedTest() throws Exception{
        Books books = new Books();
        List<Books> book = new ArrayList<>();

        Format f = new Format();
        f.setType("Audio");
        f.setUrl("https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E");
        Format g = new Format();
        g.setType("PDF");
        g.setUrl("null");
        List<Format> format = new ArrayList<>();
        format.add(f);
        format.add(g);

        List<String> category = new ArrayList<>();
        category.add("Textbooks");

        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");

        books.setId(1);
        books.setName("Astronomy");
        books.setIsbn("996-56-045-61");
        books.setAuthor("Alain.J.Brizard");
        books.setFormat(format);
        books.setLanguage("English");
        books.setBookImage("https://drive.google.com/uc?export=view&id=1sbhabVfpYDthUX-x6_4X1X_hYLl3jEKs");
        books.setDescription("Physics Atronomy textbook");
        books.setViews(3);
        books.setCategory(category);
        books.setSubCategory(sc);
        books.setRating(5);

        book.add(books);

//        System.out.println(book);
        when(homeService.getMostViewedBooks()).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/mostviewed")).andDo(print()).andExpect(status().isOk());

    }

}
