package com.trust.samarthanam.DigitalLibrary.ControllerTests;

import com.trust.samarthanam.DigitalLibrary.Controller.BooksController;
import com.trust.samarthanam.DigitalLibrary.Controller.CategoryController;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import com.trust.samarthanam.DigitalLibrary.Service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    public void getAllTest() throws Exception{
       Category category=new Category();
       category.setCategory("Textbooks");
       ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");
        sc.add("Chemistry");
        category.setSubCategory(sc);
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(category);
        when(categoryService.sortingCategories()).thenReturn(categoryList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/categories")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void findAllCategoriesTest() throws Exception{
        Category category=new Category();
        List<String> categoryList=new ArrayList<>();
        category.setCategory("Textbooks");
        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");
        sc.add("Chemistry");
        category.setSubCategory(sc);
        Category category1=new Category();
        category1.setCategory("Children");
        ArrayList<String> sc1 = new ArrayList<>();
        sc1.add("Rhymes");
        sc1.add("Poems");
        category1.setSubCategory(sc1);
        categoryList.add(category.getCategory());
        categoryList.add(category1.getCategory());
        when(categoryService.listCategory()).thenReturn((ArrayList<String>) categoryList);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/category")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void findAllsubCategoriesTest() throws Exception{
        Category category=new Category();

        category.setCategory("Textbooks");
        ArrayList<String> sc = new ArrayList<>();
        sc.add("Physics");
        sc.add("Chemistry");
        category.setSubCategory(sc);
        Category category1=new Category();
        category1.setCategory("Children");
        ArrayList<String> sc1 = new ArrayList<>();
        sc1.add("Rhymes");
        sc1.add("Poems");
        category1.setSubCategory(sc1);
        List<String> subCat=category1.getSubCategory();

        when(categoryService.listSubCategory("Children")).thenReturn(subCat);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/category/Children/subcategory")).andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void findBooksbyFormatTest() throws Exception {
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
        sc.add("Astronomy");

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

        book.add(books);

        when(categoryService.listFormatBooks("Audio","Physics")).thenReturn(book);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/books/format/Audio/subcategory/Physics")).andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json")).andExpect(jsonPath("$.author").value("Astronomy"));


    }

}