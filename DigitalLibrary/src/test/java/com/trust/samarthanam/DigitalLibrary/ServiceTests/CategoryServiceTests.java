<<<<<<< HEAD
//package com.trust.samarthanam.DigitalLibrary.ServiceTests;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.trust.samarthanam.DigitalLibrary.Model.Books;
//import com.trust.samarthanam.DigitalLibrary.Model.Category;
//import com.trust.samarthanam.DigitalLibrary.Service.CategoryService;
//import com.trust.samarthanam.DigitalLibrary.Service.HomeService;
//import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
//import com.trust.samarthanam.DigitalLibrary.dao.CategoryRepo;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class CategoryServiceTests {
//    @InjectMocks
//    @Autowired
//    CategoryService categoryService;
//
//    @Autowired
//    public CategoryRepo categoryRepo;
//    @Autowired
//    public BooksRepo booksRepo;
//
//
//
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//        saveCategory();
//    }
//
//    public void saveCategory() {
//        String CategoryList = "[{\n" +
//                "\t\"category\": \"Children\",\n" +
//                "\t\"subCategory\":[\"Rhymes\",\"Poems\",\"Story books\",\"Comics\",\"Kindergarten\"]\n" +
//                "},\n" +
//                "{\n" +
//                "\t\"category\": \"Textbooks\",\n" +
//                "\t\"subCategory\": [\"Physics\", \"Science\" ]\n" +
//                "}]\n";
//        String BooksList= "[{\n" +
//                "\t\"id\": \"1\",\n" +
//                "\t\"name\": \"Moose on the Loose\",\n" +
//                "\t\"isbn\":\"935-678-234-23\",\n" +
//                "\t\"author\":\"Lewis Carrol\",\n" +
//                "\t\"format\": {\n" +
//                "\t\"pdf\": {\n" +
//                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
//                "},\n" +
//                "\t\"audio\" :{\n" +
//                "\t\"url\":\"https://drive.google.com/uc?export=view&id=1m7SqrxcbAxKyDUfYzcKP9Rbn1EMJl9QH\"\n" +
//                "}\n"+
//                "},\n" +
//                "\t\"language\":\"English\",\n" +
//                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
//                "\t\"description\":\"Moose on the loose is about a lost moose\",\n" +
//                "\t\"views\": 4,\n" +
//                "\t\"category\":\"Children\",\n" +
//                "\t\"subCategory\":[\"Poem\"],\n"+
//                "\t\"rating\": 4\n" +
//                "},{\n" +
//                "\t\"id\": \"2\",\n" +
//                "\t\"name\": \"Alice's Adventures in Wonderland\",\n" +
//                "\t\"isbn\":\"935-678-234-23\",\n" +
//                "\t\"author\":\"Lewis Carrol\",\n" +
//                "\t\"format\": {\n" +
//                "\t\"pdf\": {\n" +
//                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
//                "}\n"+
//                "},\n" +
//                "\t\"language\":\"Kannada\",\n" +
//                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
//                "\t\"description\":\"Alice's Adventures in Wonderland, widely beloved British children's book by Lewis Carroll.The story centres on Alice\",\n" +
//                "\t\"views\": 4,\n" +
//                "\t\"category\":\"Children\",\n" +
//                "\t\"subCategory\":[\"Poem\",\"Rhymes\"],\n"+
//                "\t\"rating\": 4\n" +
//                "}]\n";
//        try {
//            Category categories[] = new ObjectMapper().readValue(CategoryList, Category[].class);
//            Books books[] = new ObjectMapper().readValue(BooksList, Books[].class);
//
//            for (Books book1 : books) {
//                booksRepo.save(book1);
//            }
//            for (Category cat1 : categories) {
//                categoryRepo.save(cat1);
//            }
//
//
//        } catch (JsonMappingException e) {
//            e.printStackTrace();
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        } catch (org.springframework.dao.DuplicateKeyException e) {
//        }
//
//
//    }
//
//    @Test
//    public void ListAllCategoryTest() {
//        List<Category> c = categoryService.listAll();
//        Assert.assertEquals(2, c.size());
//    }
//    @Test
//    public void ListCategoryTest() {
//        ArrayList<String> c = categoryService.listCategory();
//        Assert.assertEquals(2 ,c.size());
//    }
//    @Test
//    public void ListSubcategoryTest() {
//        ArrayList<String> c = (ArrayList<String>) categoryService.listSubCategory("Children");
//        Assert.assertEquals(5 ,c.size());
//    }
=======
package com.trust.samarthanam.DigitalLibrary.ServiceTests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Service.CategoryService;
import com.trust.samarthanam.DigitalLibrary.Service.HomeService;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import com.trust.samarthanam.DigitalLibrary.dao.CategoryRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTests {
    @InjectMocks
    @Autowired
    CategoryService categoryService;

    @Autowired
    public CategoryRepo categoryRepo;
    @Autowired
    public BooksRepo booksRepo;




    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        saveCategory();
    }

    public void saveCategory() {
        String CategoryList = "[{\n" +
                "\t\"category\": \"Children\",\n" +
                "\t\"subCategory\":[\"Rhymes\",\"Poems\",\"Story books\",\"Comics\",\"Kindergarten\"]\n" +
                "},\n" +
                "{\n" +
                "\t\"category\": \"Textbooks\",\n" +
                "\t\"subCategory\": [\"Physics\", \"Science\" ]\n" +
                "}]\n";
        String BooksList= "[{\n" +
                "\t\"id\": \"1\",\n" +
                "\t\"name\": \"Moose on the Loose\",\n" +
                "\t\"isbn\":\"935-678-234-23\",\n" +
                "\t\"author\":\"Lewis Carrol\",\n" +
                "\t\"format\": {\n" +
                "\t\"pdf\": {\n" +
                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
                "},\n" +
                "\t\"audio\" :{\n" +
                "\t\"url\":\"https://drive.google.com/uc?export=view&id=1m7SqrxcbAxKyDUfYzcKP9Rbn1EMJl9QH\"\n" +
                "}\n"+
                "},\n" +
                "\t\"language\":\"English\",\n" +
                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
                "\t\"description\":\"Moose on the loose is about a lost moose\",\n" +
                "\t\"views\": 4,\n" +
                "\t\"category\":\"Children\",\n" +
                "\t\"subCategory\":[\"Poem\"],\n"+
                "\t\"rating\": 4\n" +
                "},{\n" +
                "\t\"id\": \"2\",\n" +
                "\t\"name\": \"Alice's Adventures in Wonderland\",\n" +
                "\t\"isbn\":\"935-678-234-23\",\n" +
                "\t\"author\":\"Lewis Carrol\",\n" +
                "\t\"format\": {\n" +
                "\t\"pdf\": {\n" +
                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
                "}\n"+
                "},\n" +
                "\t\"language\":\"Kannada\",\n" +
                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
                "\t\"description\":\"Alice's Adventures in Wonderland, widely beloved British children's book by Lewis Carroll.The story centres on Alice\",\n" +
                "\t\"views\": 4,\n" +
                "\t\"category\":\"Children\",\n" +
                "\t\"subCategory\":[\"Poem\",\"Rhymes\"],\n"+
                "\t\"rating\": 4\n" +
                "}]\n";
        try {
            Category categories[] = new ObjectMapper().readValue(CategoryList, Category[].class);
            Books books[] = new ObjectMapper().readValue(BooksList, Books[].class);

            for (Books book1 : books) {
                booksRepo.save(book1);
            }
            for (Category cat1 : categories) {
                categoryRepo.save(cat1);
            }


        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (org.springframework.dao.DuplicateKeyException e) {
        }


    }

    @Test
    public void ListAllCategoryTest() {
        List<Category> c = categoryService.listAll();
        Assert.assertEquals(2, c.size());
    }
    @Test
    public void ListCategoryTest() {
        ArrayList<String> c = categoryService.listCategory();
        Assert.assertEquals(2 ,c.size());
    }
    @Test
    public void ListSubcategoryTest() {
        ArrayList<String> c = (ArrayList<String>) categoryService.listSubCategory("Children");
        Assert.assertEquals(5 ,c.size());
    }
>>>>>>> develop
//    @Test
//    public void ListSubcategoryByFormatTest() {
//        List<Books> c = categoryService.listFormatBooks("pdf","Poem");
//        Assert.assertEquals(2 ,c.size());
//    }
<<<<<<< HEAD
//
//
//}
//
//
//
//
//
=======


}





>>>>>>> develop
