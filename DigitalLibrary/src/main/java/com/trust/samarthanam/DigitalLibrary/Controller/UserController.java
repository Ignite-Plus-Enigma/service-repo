package com.trust.samarthanam.DigitalLibrary.Controller;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.SavedBook;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import com.trust.samarthanam.DigitalLibrary.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:3000")

@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    //---------------------------------------------get all users--------------------------------------------------------
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //----------------------------------------------save a book of a user-----------------------------------------------
    @PostMapping("/user/{id}/savebook")
    public User savebook(@PathVariable String id, @RequestBody SavedBook book){
        return userService.saveBook(id,book);
    }

    //--------------------------------------------save a user-----------------------------------------------------------
    @PostMapping("/user/save")
    public User saveuser(@RequestBody User newUser){
        return userService.saveuser(newUser);
    }

    //----------------------------------------------get the role of a user----------------------------------------------
    @GetMapping("/user/{id}/role")
    public String getrole(@PathVariable String id){
        return userService.getrole(id);
    }

    //-------------------------------------------get all the saved books of a particular user---------------------------
    @GetMapping("/user/{id}/savedbooks")
    public ArrayList<Optional<Books>> getsavedbooks(@PathVariable String id){
        return userService.getsavedbooks(id);
    }

    //----------------------------------------------mark a book finished -----------------------------------------------
    @PutMapping("/user/{id}/savedbook/{bookId}/markfinished")
    public User markfinished(@PathVariable String id,@PathVariable String bookId){
            return userService.markfinished(id,bookId);
    }

    //--------------------------------------------update the progress of a book ----------------------------------------
    @PutMapping("/user/{id}/savedbook/{bookId}/progress")
    public User updateProgress(@PathVariable String id,@PathVariable String bookId, @RequestBody String progress){
        return userService.updateProgress(id,bookId,progress);
    }


}
