package com.trust.samarthanam.DigitalLibrary.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trust.samarthanam.DigitalLibrary.Controller.BooksController;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksController.class)
public class BooksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService booksService;

    @Test
    public void getBooksTest() throws Exception{
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
        when(booksService.listBooks()).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books")).andDo(print()).andExpect(status().isOk());


    }

    @Test
    public void getByIdTest() throws Exception{
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

        when(booksService.getById(1)).thenReturn(books);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/1")).andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void getByFormatTest() throws Exception{
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

        when(booksService.getBookByFormat("Audio")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/format/Audio")).andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void findBookTest() throws Exception{
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

        when(booksService.searchBooks("Astronomy")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/search=Astronomy")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void findBookByTopicTest() throws Exception{
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

        when(booksService.getBooksBySubCategory("Physics")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/subcategory/Physics")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void saveBookTest() throws Exception{
        Books books = new Books();
//        List<Books> book = new ArrayList<>();

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

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

//        book.add(books);

        when(booksService.saveBook(books)).thenReturn(books);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/books/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(books ))).andDo(print()).andExpect(status().isOk());
    }

}
