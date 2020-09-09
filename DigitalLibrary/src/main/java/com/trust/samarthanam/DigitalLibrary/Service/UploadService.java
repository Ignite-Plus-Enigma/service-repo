package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Exceptions.UserNotFoundException;
import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Model.SavedBook;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import com.trust.samarthanam.DigitalLibrary.dao.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UploadService {
    @Autowired
    NextSequenceService nextSequenceService;
    @Autowired
    BooksRepo booksRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public Books addBook(Books newBook) {
        newBook.setId(nextSequenceService.getNextSequence(Books.SEQUENCE_NAME));
        booksRepo.save(newBook);

        return newBook;

    }

    public Category addCategory(Category newCategory) {
        categoryRepo.save(newCategory);
        return newCategory;

    }

    public Category addNewSubcategoryToOldCategory(Category newCategory) {
        String category = newCategory.getCategory();
        List<String> newSubcategory = newCategory.getSubCategory();
        Category oldCategory = categoryRepo.findById(category).get();
        List<String> subCategory = oldCategory.getSubCategory();
        for (String s: subCategory) {
            newSubcategory.add(s);
        }
        oldCategory.setSubCategory( newSubcategory);;
        categoryRepo.save(oldCategory);
        return oldCategory;


    }
}