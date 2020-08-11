package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "User")

public class User {
    @Id
    @Field("_id")
    private String googleId;
    @Field("saved_books")
    private List<SavedBook> savedBooks;
    @Field("role")
    private String role;

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public List<SavedBook> getSavedBooks() {
        return savedBooks;
    }

    public void setSavedBooks(List<SavedBook> savedBooks) {
        this.savedBooks = savedBooks;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "googleId='" + googleId + '\'' +
                ", savedBooks=" + savedBooks +
                ", role='" + role + '\'' +
                '}';
    }
}
