package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.SavedBook;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EditService {

    @Autowired
    BookService bookService;
    @Autowired
    BooksRepo booksRepo;

    MongoTemplate mongoTemplate;
    public Books getById(int id){
        List<Books> books = booksRepo.findAll();
        for (Books book : books){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }
    public Books Editbook(int id, Books newBook) {
     Books book=getById(id);

     String newName = newBook.getName();
//            book.setName(newBook.getName());
//            book.setIsbn(newBook.getIsbn());
//            book.setFormat(newBook.getFormat());
//            book.setCategory(newBook.getCategory());
//            book.setSubCategory(newBook.getSubCategory());
//            book.setDescription(newBook.getDescription());
//            book.setBookImage(newBook.getBookImage());
//            book.setAuthor(newBook.getAuthor());
//            book.setLanguage(newBook.getLanguage());
//            book.setName(newName);
            booksRepo.save(book);
            System.out.println(book);
            return book;

    }




    }








