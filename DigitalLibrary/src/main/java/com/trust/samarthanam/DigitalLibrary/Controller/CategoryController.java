package com.trust.samarthanam.DigitalLibrary.Controller;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //------------------------------------get all entries in Category collection----------------------------------------
    @GetMapping("/categories")
    public List<Category> getAll(){
        return categoryService.listAll();
    }

    //------------------------------------get all main categories-------------------------------------------------------
    @GetMapping("/category")
    public List<String> findAllCategory(){
        return categoryService.listCategory();
    }

    //--------------------------------get all subcategory of a main category--------------------------------------------
    @GetMapping("/category/{key}/subcategory")
    public List<String> findAllSubCategory(@PathVariable String key){
        return categoryService.listSubCategory(key);
    }

    //----------------------------get all books of a subcategory and a particular format -------------------------------
    @GetMapping("/books/format/{format}/subcategory/{subName}")
    public Collection<Books> findBooksbyFormat(@PathVariable String format, @PathVariable String subName){
        return categoryService.listFormatBooks(format,subName);
    }
}
