package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Exceptions.BookNotFoundException;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookService {
    @Autowired
    private BooksRepo booksRepo;


//---------------------------------------list all books-----------------------------------------------------------------
    public List<Books> listBooks() {
        return booksRepo.findAll();
    }

    public List<Books> getBookByFormat(String key){
        ArrayList<Books> test = new ArrayList<>();
        ArrayList<Books> bookByFormat = new ArrayList<>();
        test = (ArrayList<Books>) booksRepo.findAll();
        for(Books book : test){
            for(Format f : book.getFormat()){
                if(f.getType().equals(key)){
                    bookByFormat.add(book);
                }
            }
        }
        return bookByFormat;

    }
//---------------------------------------get books by id----------------------------------------------------------------
    public Books getById(int id)
    {
        Collection<Books> books = booksRepo.findAll();
        for(Books book : books){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

////-------------------------------------get books by keywords------------------------------------------------------------
    @Autowired
    MongoTemplate mongoTemplate;

    public Collection searchBooks(String text) {
        Collection<Books> b = mongoTemplate.find(Query.query(new Criteria()
                .orOperator(Criteria.where("isbn").regex(text, "i"),
                        Criteria.where("name").regex(text, "i"),
                        Criteria.where("author").regex(text, "i"),
                        Criteria.where("category").regex(text, "i"),
                        Criteria.where("subCategory").regex(text, "i"),
                        Criteria.where("language").regex(text, "i"),
                        Criteria.where("description").regex(text, "i"),
                        Criteria.where("format").regex(text, "i"))), Books.class);
        if(b.isEmpty())
            throw new BookNotFoundException("");
        else
            return b;
    }

////----------------------------------------get books by subcategory/topic------------------------------------------------
    public Collection getBooksBySubCategory(String key) {
        Collection<Books> b = mongoTemplate.find(Query.query(new Criteria()
                .andOperator(Criteria.where("subCategory").regex(key, "i")
                        )), Books.class);
        if(b.isEmpty())
            throw new BookNotFoundException("");
        else
            return b;
    }

    public Books saveBook(Books book){
        booksRepo.save(book);
        return book;
    }
}


