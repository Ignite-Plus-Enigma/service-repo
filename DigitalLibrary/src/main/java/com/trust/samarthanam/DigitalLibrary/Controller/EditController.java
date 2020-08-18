//package com.trust.samarthanam.DigitalLibrary.Controller;
//
//import com.trust.samarthanam.DigitalLibrary.Model.Books;
//import com.trust.samarthanam.DigitalLibrary.Model.User;
//import com.trust.samarthanam.DigitalLibrary.Service.BookService;
//import com.trust.samarthanam.DigitalLibrary.Service.EditService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.awt.print.Book;
//import java.util.Collection;
//
//@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins="http://localhost:3000")
//public class EditController {
//    @Autowired
//    private BookService bookService;
//    @Autowired
//    private EditService editService;
//
////    @GetMapping("/books/search={key}")
////    public Collection<Books> findBook(@PathVariable String key) {
////        return bookService.searchBooks(key);
////    }
//
//    @PutMapping("/editbook/{id}")
//    public Books editBook(@PathVariable String id,@RequestBody Books book){
//      Books b= editService.Editbook(id,book);
//        return  b;
//    }
//
//
//
//
//
//
//
//
//}
