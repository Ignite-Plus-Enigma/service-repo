package com.trust.samarthanam.DigitalLibrary.ServiceTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trust.samarthanam.DigitalLibrary.DigitalLibraryApplicationTests;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Service.HomeService;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.data.mongodb.core.query.Query.query;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeServiceTests{

    @InjectMocks
    @Autowired
    HomeService homeService;

    @Autowired
    public BooksRepo booksRepo;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        saveBooks();
    }

    public void saveBooks() {
        String BooksList = "[{\n" +
                "\t\"id\": \"1\",\n" +
                "\t\"name\": \"Alice's Adventures in Wonderland\",\n" +
                "\t\"isbn\":\"935-678-234-23\",\n" +
                "\t\"author\":\"Lewis Carrol\",\n" +
                "\t\"format\": {\n" +
                "\t\"pdf\": {\n" +
                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
                "},\n" +
                "\t\"audio\" :{\n" +
                "\t\"url\":\"https://drive.google.com/uc?export=view&id=1m7SqrxcbAxKyDUfYzcKP9Rbn1EMJl9QH\"\n" +
                "}\n" +
                "},\n" +
                "\t\"language\":\"English\",\n" +
                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
                "\t\"description\":\"Alice's Adventures in Wonderland, widely beloved British children's book by Lewis Carroll.The story centres on Alice\",\n" +
                "\t\"views\": 4,\n" +
                "\t\"category\":\"Children\",\n" +
                "\t\"subCategory\":[\"Story books\"],\n" +
                "\t\"rating\": 4\n" +
                "},{\n" +
                "\t\"id\": \"2\",\n" +
                "\t\"name\": \"Alice's Adventures in Wonderland\",\n" +
                "\t\"isbn\":\"935-678-234-23\",\n" +
                "\t\"author\":\"Lewis Carrol\",\n" +
                "\t\"format\": {\n" +
                "\t\"pdf\": {\n" +
                "\t\"url\": \"https://drive.google.com/uc?export=view&id=1K7eJ9Wvlvo8_2BpMmqshQi8OKBijl49E\"\n" +
                "},\n" +
                "\t\"audio\" :{\n" +
                "\t\"url\":\"https://drive.google.com/uc?export=view&id=1m7SqrxcbAxKyDUfYzcKP9Rbn1EMJl9QH\"\n" +
                "}\n" +
                "},\n" +
                "\t\"language\":\"Kannada\",\n" +
                "\t\"bookImage\":\"https://drive.google.com/uc?export=download&id=1Sqc63-nx8nPnBGkOgpqs1uFLr1JcW60R\",\n" +
                "\t\"description\":\"Alice's Adventures in Wonderland, widely beloved British children's book by Lewis Carroll.The story centres on Alice\",\n" +
                "\t\"views\": 4,\n" +
                "\t\"category\":\"Children\",\n" +
                "\t\"subCategory\":[\"Story books\"],\n" +
                "\t\"rating\": 4\n" +
                "}]\n";


        try {
            Books books[] = new ObjectMapper().readValue(BooksList, Books[].class);

            for (Books book1 : books) {
                booksRepo.save(book1);
            }


        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (org.springframework.dao.DuplicateKeyException e) {
        }
    }
    @Test
    public void LanguageSearchTest() {
        Collection<Books> b = homeService.findBooksByLanguage("Kannada");
        List<Books> book = new ArrayList<>(b);
        Assert.assertEquals(1,b.size());
    }

    @Test
    public void findBooksByCategoryTest(){
        Collection<Books> b = homeService.findBooksByCategory("Children");
        List<Books> book = new ArrayList<>(b);
        Assert.assertEquals(2,b.size());

    }
    @Test
    public void findRecentlyAddedBooksTest(){
        List<Books> b = homeService.findRecentlyAddedBooks();
        Assert.assertEquals(2,b.size());
    }
    @Test
    public void getMostViewedBooksTest(){
        List<Books> b = homeService.getMostViewedBooks();
        Assert.assertEquals(4,b.get(0).getViews());

    }

}




