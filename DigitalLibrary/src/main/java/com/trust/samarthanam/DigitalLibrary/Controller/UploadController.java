package com.trust.samarthanam.DigitalLibrary.Controller;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Category;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import com.trust.samarthanam.DigitalLibrary.Service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/api/v1")
public class UploadController {

    @Autowired
    UploadService uploadService;
    //---------------------------------------To upload a new book---------------------------------------------------------------------------
    @PostMapping("/book/add")
    public Books addNewBook(@RequestBody Books newBook){
        return uploadService.addBook(newBook);
    }
    //--------------------------To add new category and new subcategories under it-----------------------------------------------------------
    @PostMapping("/newCatAndSubcat/add")
    public Category addNewCategory(@RequestBody Category newCategory){
        return uploadService.addCategory(newCategory);
    }

    //----------------------To update a existing category with new subcategories-----------------------------------------------------------
    @PutMapping("/oldCatAndNewsubCat/add")
    public Category updateOldCategory(@RequestBody Category newCategory) {
        return uploadService.addNewSubcategoryToOldCategory(newCategory);
    }


}
