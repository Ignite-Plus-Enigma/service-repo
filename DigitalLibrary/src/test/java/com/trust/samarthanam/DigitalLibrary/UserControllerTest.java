package com.trust.samarthanam.DigitalLibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trust.samarthanam.DigitalLibrary.Controller.UserController;
import com.trust.samarthanam.DigitalLibrary.Model.*;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import com.trust.samarthanam.DigitalLibrary.Service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @MockBean
    private BookService bookService;

    @Test
    public void getAllUsersTest() throws Exception{
        User users = new User();
        List<User> user = new ArrayList<>();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);
        user.add(users);
        when(userService.getAllUsers()).thenReturn(user);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users")).andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void getUserByIdTest() throws Exception{
        User users = new User();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.getById("1234")).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1234")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void getUserRoleTest() throws Exception{
        User users = new User();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.getrole("1234")).thenReturn("User");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1234/role")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void getSavedBooksTest() throws Exception{
        User users = new User();
        Books books = new Books();
        ArrayList<Books> book = new ArrayList<>();

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

        List<SavedBook> savedbooks = new ArrayList<>();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("False");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        savedbooks.add(s);
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

        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.getsavedbooks("1234")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1234/savedbooks")).andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void getContinueReadingBooksTest() throws Exception{
        User users = new User();
        Books books = new Books();
        ArrayList<Books> book = new ArrayList<>();

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

        List<SavedBook> savedbooks = new ArrayList<>();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("False");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        savedbooks.add(s);
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

        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.getContinueReadingBooks("1234")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1234/continuereading")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void getFinishedBooksTest() throws Exception{
        User users = new User();
        Books books = new Books();
        ArrayList<Books> book = new ArrayList<>();

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

        List<SavedBook> savedbooks = new ArrayList<>();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        savedbooks.add(s);
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

        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.getFinishedBooks("1234")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/1234/finishedbooks")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void saveBookTest() throws Exception {

        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);



        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        User users = new User();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.saveBook("1234",s)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/1234/savebook")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(users))).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void unsaveBookTest() throws Exception{
        User users = new User();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);



        List<SavedBook> savedbooks = new ArrayList<>();
        savedbooks.add(s);
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.unsaveBook("1234",1)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/1234/unsavebook/1")).andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void markFinishedTest() throws Exception{
        User users = new User();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("False");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        List<SavedBook> savedbooks = new ArrayList<>();
        savedbooks.add(s);
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.markfinished("1234",1)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1//user/1234/savedbook/1/markfinished")).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void markUnfinishedTest() throws Exception{
        User users = new User();
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        List<SavedBook> savedbooks = new ArrayList<>();
        savedbooks.add(s);
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.markfinished("1234",1)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1//user/1234/savedbook/1/markUnfinished")).andDo(print()).andExpect(status().isOk());

    }


    @Test
    public void updateProgressTest() throws Exception{
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        Progress update = new Progress();
        update.setRemaining(80);
        update.setLength(120);
        update.setFormat("Audio");



        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        User users = new User();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.updateProgress("1234",1,update)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/user/1234/savedbook/1/progress")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(users))).andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void saveUserTest() throws Exception{
        SavedBook s = new SavedBook();
        s.setBookId(1);
        s.setIsFinished("True");

        Progress p = new Progress();
        p.setRemaining(100);
        p.setFormat("Audio");
        p.setLength(100);

        List<Progress> progress = new ArrayList<>();
        progress.add(p);

        s.setProgress(progress);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        User users = new User();

        List<SavedBook> savedbooks = new ArrayList<>();
        List<SavedBook> finishedBooks = new ArrayList<>();
        users.setGoogleId("1234");
        users.setRole("User");
        users.setSavedBooks(savedbooks);
        users.setFinishedBooks(finishedBooks);

        when(userService.saveuser(users)).thenReturn(users);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(users))).andDo(print()).andExpect(status().isOk());

    }





}