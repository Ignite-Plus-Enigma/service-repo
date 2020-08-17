package com.trust.samarthanam.DigitalLibrary.Service;

import com.mongodb.*;

import static com.mongodb.client.model.Aggregates.*;

import com.mongodb.client.*;
import com.mongodb.client.MongoClient;
import com.mongodb.connection.ClusterDescription;
import com.trust.samarthanam.DigitalLibrary.Exceptions.BookNotFoundException;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Format;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.*;

@Component

public class BookService {
    @Autowired
    private BooksRepo booksRepo;

    MongoClient mongoClient = new MongoClient() {
        @Override
        public MongoDatabase getDatabase(String s) {
            return null;
        }


        @Override
        public ClientSession startSession() {
            return null;
        }

        @Override
        public ClientSession startSession(ClientSessionOptions clientSessionOptions) {
            return null;
        }

        @Override
        public void close() {

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


        }

        @Override
        public MongoIterable<String> listDatabaseNames() {
            return null;
        }

        @Override
        public MongoIterable<String> listDatabaseNames(ClientSession clientSession) {
            return null;
        }

        @Override
        public ListDatabasesIterable<org.bson.Document> listDatabases() {
            return null;
        }

        @Override
        public ListDatabasesIterable<org.bson.Document> listDatabases(ClientSession clientSession) {
            return null;
        }

        @Override
        public <TResult> ListDatabasesIterable<TResult> listDatabases(Class<TResult> aClass) {
            return null;
        }

        @Override
        public <TResult> ListDatabasesIterable<TResult> listDatabases(ClientSession clientSession, Class<TResult> aClass) {
            return null;
        }

        @Override
        public ChangeStreamIterable<org.bson.Document> watch() {
            return null;
        }

        @Override
        public <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> aClass) {
            return null;
        }

        @Override
        public ChangeStreamIterable<org.bson.Document> watch(List<? extends Bson> list) {
            return null;
        }

        @Override
        public <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> list, Class<TResult> aClass) {
            return null;
        }

        @Override
        public ChangeStreamIterable<org.bson.Document> watch(ClientSession clientSession) {
            return null;
        }

        @Override
        public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> aClass) {
            return null;
        }

        @Override
        public ChangeStreamIterable<org.bson.Document> watch(ClientSession clientSession, List<? extends Bson> list) {
            return null;
        }

        @Override
        public <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> list, Class<TResult> aClass) {
            return null;
        }

        @Override
        public ClusterDescription getClusterDescription() {
            return null;
        }
    };
    MongoDatabase database = mongoClient.getDatabase("test");

    public List<Books> listAll(){
        return booksRepo.findAll();
    }


////---------------------------------------list all books-----------------------------------------------------------------
//    public List<Books> listBooks() {
//        ArrayList<Books> test = new ArrayList<>();
//        test = (ArrayList<Books>) booksRepo.findAll();
//        for (Books book : test){
//            System.out.println(book.getFormat());
//            Map<String, Object> list = book.getFormat();
//        }
//         return (List<Books>) booksRepo.findAll();
//
//    }
//
//    public List<Books> getBookByFormat(String format){
//        ArrayList<Books> test = new ArrayList<>();
//        test = (ArrayList<Books>) booksRepo.findAll();
//        ArrayList<Books> fbook = new ArrayList<>();
//        for (Books book : test){
//            Map<String, Object> list = book.getFormat();
//            if(list.get(format) != null){
//                fbook.add(book);
//            }
//        }
//        return fbook;
//    }
////---------------------------------------get books by id----------------------------------------------------------------
//    public Books getById(String id)
//    {
////        Optional<Books> optionalBooks = booksRepo.findById(id);
////        if(optionalBooks.isEmpty())
////            throw new BookNotFoundException("Book Not Found!");
////        return optionalBooks;
//        Collection<Books> books = booksRepo.findAll();
//        for(Books book : books){
//            if(book.getId().equals(id)){
//                return book;
//            }
//        }
//        return null;
//    }
//////-------------------------------------get books by keywords------------------------------------------------------------
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    public Collection searchBooks(String text) {
//        Collection<Books> b = mongoTemplate.find(Query.query(new Criteria()
//                .orOperator(Criteria.where("isbn").regex(text, "i"),
//                        Criteria.where("name").regex(text, "i"),
//                        Criteria.where("author").regex(text, "i"),
//                        Criteria.where("category").regex(text, "i"),
//                        Criteria.where("subCategory").regex(text, "i"),
//                        Criteria.where("language").regex(text, "i"),
//                        Criteria.where("description").regex(text, "i"),
//                        Criteria.where("format").regex(text, "i"))), Books.class);
//        if(b.isEmpty())
//            throw new BookNotFoundException("");
//        else
//            return b;
//    }
//
//////----------------------------------------get books by subcategory/topic------------------------------------------------
//    public Collection getBooksBySubCategory(String key) {
//        Collection<Books> b = mongoTemplate.find(Query.query(new Criteria()
//                .andOperator(Criteria.where("subCategory").regex(key, "i")
//                        )), Books.class);
//        if(b.isEmpty())
//            throw new BookNotFoundException("");
//        else
//            return b;
//    }
//
//    public Books saveBook(Books book){
//        booksRepo.save(book);
//        return book;
//    }


    MongoCollection<org.bson.Document> collection = database.getCollection("Books");

    AggregateIterable<Document> output = collection.aggregate(Arrays.asList(
            new Document("$unwind", "$category"),
            new Document("$match", new Document("category.main_category", "Category2"))
    ));



}


