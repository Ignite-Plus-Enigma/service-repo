package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Exceptions.BookNotFoundException;
import com.trust.samarthanam.DigitalLibrary.Exceptions.CategoryNotFoundException;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import com.trust.samarthanam.DigitalLibrary.dao.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BooksRepo booksRepo;

    //--------------------------------------- list all entries of Catgeoyr Collection ----------------------------------
    public List<Category> listAll() {
        return categoryRepo.findAll();
    }

    //----------------------------------------list all categories ----------------------------------------------------------
    public ArrayList<String> listCategory() {
        ArrayList<String> categories=new ArrayList<String>();
        List<Category> l = categoryRepo.findAll();
        for(Category category: l ){
            categories.add(category.getCategory());
        };
        return categories;
    }


    //---------------------------------------list all subcategories of a main category----------------------------------
    public List<String> listSubCategory(String key) {
        List<Category> l = categoryRepo.findAll();
        ArrayList<String> subcategories = new ArrayList<>();
        for(Category c : l){
            if(c.getCategory().equals(key)){
                subcategories = (ArrayList<String>) c.getSubCategory();
                Collections.sort(subcategories);
            }
        }
        if(subcategories.isEmpty())
            throw new CategoryNotFoundException("Sorry category"+key+"Not Found!");
        else
            return subcategories;
    }

    //---------------------------------------list all main categories sorted by alphabeical order-----------------------
    public List<Category>sortingCategories(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC,"category"));
        return mongoTemplate.find(query, Category.class);
    }

    //-----------------------------------list books belonging to a subcategory of a particular format-------------------
    public Collection<Books> listFormatBooks(String format,String subName) {
        Collection<Books> b = mongoTemplate.find(Query.query(new Criteria()
                .andOperator(Criteria.where("format.type").regex(format, "i"),
                        Criteria.where("sub_category").regex(subName, "i")
                       )), Books.class);
        if(b.isEmpty())
            throw new BookNotFoundException("");
        else
            return b;
    }
}
