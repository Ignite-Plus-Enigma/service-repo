package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "User")

public class User {
    @Id
    @Field("_id")
    private String id;
    @Field("google_id")
    private String googleId;
    @Field("saved_books")
    private List<Object> savedBooks;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public List<Object> getSavedBooks() {
        return savedBooks;
    }

    public void setSavedBooks(List<Object> savedBooks) {
        this.savedBooks = savedBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", googleId='" + googleId + '\'' +
                ", savedBooks=" + savedBooks +
                '}';
    }
}
