package com.trust.samarthanam.DigitalLibrary.ControllerTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.trust.samarthanam.DigitalLibrary.Controller.CategoryController;
import com.trust.samarthanam.DigitalLibrary.Controller.UploadController;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.Service.CategoryService;
import com.trust.samarthanam.DigitalLibrary.Service.UploadService;
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
@WebMvcTest(UploadController.class)
public class UploadControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UploadService uploadService;

    @Test
    public void addNewbookTest() throws Exception{


        Books books = new Books();
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
        books.setDescription("Physics Astronomy textbook");
        books.setViews(3);
        books.setCategory(category);
        books.setSubCategory(sc);
        books.setRating(5);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();

//        book.add(books);

        when(uploadService.addBook(books)).thenReturn(books);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/book/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(books))).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void addNewCategoryTest() throws Exception
    {
        Category category=new Category();
        List<String> categoryList=new ArrayList<>();
        category.setCategory("Textbooks");
        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");
        sc.add("Chemistry");
        category.setSubCategory(sc);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        when(uploadService.addCategory(category)).thenReturn(category);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/newCatAndSubcat/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(category))).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void addNewCategoryOldsubCatTest() throws Exception
    {
        
    }

}


