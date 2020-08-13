package com.trust.samarthanam.DigitalLibrary.Service;

import com.trust.samarthanam.DigitalLibrary.Model.Books;
import com.trust.samarthanam.DigitalLibrary.Model.Progress;
import com.trust.samarthanam.DigitalLibrary.Model.SavedBook;
import com.trust.samarthanam.DigitalLibrary.Model.User;
import com.trust.samarthanam.DigitalLibrary.dao.BooksRepo;
import com.trust.samarthanam.DigitalLibrary.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    MongoTemplate mongoTemplate;


    //------------------------------------------------get all users-----------------------------------------------------
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    //------------------------------------------------get user by id----------------------------------------------------
    public User getById(String id){
        List<User> users = userRepo.findAll();
        for (User user : users){
            if(user.getGoogleId().equals(id)){
                return user;
            }
        }
        return null;
    }

    //----when a user logs in check if he is already present in the database, if not save the user to the database------
    public User saveuser(User newUser){
        Optional<User> user = userRepo.findById(newUser.getGoogleId());
        if(!user.isPresent()){
            userRepo.save(newUser);
            return newUser;
        }
        else{
            return null;
        }
    }

    //-------------------------------------------save a book of an existing user ---------------------------------------
    public User saveBook(String id, SavedBook savebook){
        User user = getById(id);
        if(user!=null){
            System.out.println(user.getSavedBooks().add((SavedBook) savebook));
            userRepo.save(user);
            return user;
        }
        else{
            return null;
        }
    }

    //------------------------------------- unsave a book---------------------------------------------------------------
    public String unsaveBook(String id, String bookid){
        User user = getById(id);
        if(user!=null){
            for (SavedBook book : user.getSavedBooks()){
                if(book.getBookId().equals(bookid)){
                    user.getSavedBooks().remove(book);
                    userRepo.save(user);
                }
            }

        }
        return "Success";
    }


    //-------------------------------------------get role of a user-----------------------------------------------------
    public String getrole(String id){
        User user = getById(id);
        if(user.getRole().equals("User")){
            return "Hello User";
        }
        else if(user.getRole().equals("Admin")){
            return "Hello Admin";
        }
        else{
            return "Not Found";
        }
    }

    //-------------------------------get all saved books of a user------------------------------------------------------

    public ArrayList<Optional<Books>> getsavedbooks(String id){
        User user = getById(id);
        ArrayList<Optional<Books>> saved = new ArrayList<>();
        if(user!=null){
            for(SavedBook book : user.getSavedBooks()){
                String bookId = book.getBookId();
                Optional<Books> save = booksRepo.findById(bookId);
                saved.add(save);
            }
        }
        return saved;
    }

    //-----------------------------------mark a book finished ----------------------------------------------------------
    public User markfinished(String id,String bookId){
        User user = getById(id);
        for(SavedBook book : user.getSavedBooks()){
            if(book.getBookId().equals(bookId)){
                book.setIsFinished("True");

            }
        }
        userRepo.save(user);
        return user;
    }


    public User markUnfinished(String id,String bookId){
        User user = getById(id);
        for(SavedBook book : user.getSavedBooks()){
            if(book.getBookId().equals(bookId)){
                book.setIsFinished("False");

            }
        }
        userRepo.save(user);
        return user;
    }

    //----------------------------------------------update progress of a book-------------------------------------------
    public User updateProgress(String id, String bookId, Progress progress){
        User user = getById(id);
        for(SavedBook book : user.getSavedBooks()){
            if(book.getBookId().equals(bookId)){
                for (Progress p : book.getProgress()){
                    if(p.getFormat().equals(progress.getFormat())){
                        p.setPercentage(progress.getPercentage());
                    }
                }
            }
        }
        userRepo.save(user);
        return user;
    }

}