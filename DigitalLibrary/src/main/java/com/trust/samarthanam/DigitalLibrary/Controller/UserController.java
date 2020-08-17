package com.trust.samarthanam.DigitalLibrary.Controller;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Progress;
import com.trust.samarthanam.DigitalLibrary.Model.SavedBook;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.Service.BookService;
import com.trust.samarthanam.DigitalLibrary.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    //-------------------------------------------get user by id---------------------------------------------------------
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable String id){
        return userService.getById(id);
    }

    //----------------------------------------------save a book of a user-----------------------------------------------
    @PostMapping("/user/{id}/savebook")
    public User savebook(@PathVariable String id, @RequestBody SavedBook book){
        return userService.saveBook(id,book);
    }

    //------------------------------------------unsave a book of a user-------------------------------------------------
    @PutMapping("/user/{id}/unsavebook/{bookid}")
    public User unsavebook(@PathVariable String id, @PathVariable int bookid){
        return userService.unsaveBook(id,bookid);
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
    public ArrayList<Books> getsavedbooks(@PathVariable String id){
        return userService.getsavedbooks(id);
    }

    //----------------------------------------------mark a book finished -----------------------------------------------
    @PutMapping("/user/{id}/savedbook/{bookId}/markfinished")
    public User markfinished(@PathVariable String id,@PathVariable int bookId){
            return userService.markfinished(id,bookId);
    }

    //--------------------------------------------mark a book unfinished-----------------------------------------------
    @PutMapping("/user/{id}/savedbook/{bookId}/markUnfinished")
    public User markUnfinished(@PathVariable String id,@PathVariable int bookId){
        return userService.markUnfinished(id,bookId);
    }

    //--------------------------------------------update the progress of a book ----------------------------------------
    @PutMapping("/user/{id}/savedbook/{bookId}/progress")
    public User updateProgress(@PathVariable String id,@PathVariable int bookId, @RequestBody Progress progress){
        return userService.updateProgress(id,bookId,progress);
    }

    //----------------------------------continue reading book of a particular user--------------------------------------
    @GetMapping("/user/{id}/continuereading")
    public ArrayList<Books> getContinueReadingBooks(@PathVariable String id){
        return userService.getContinueReadingBooks(id);
    }




}
