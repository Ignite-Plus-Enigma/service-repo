package com.trust.samarthanam.DigitalLibrary.Model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;


@Document(collection = "Books")

public class Books {
    @Field("_id")
    private int id;
//    @Field("name")
//    private String name;
//    @Field("isbn")
//    private String isbn;
//    @Field("author")
//    private String author;
    @Field("format")
    private List<Format> format;
//    @Field("language")
//    private String language;
//    @Field("book_image")
//    private String bookImage;
//    @Field("description")
//    private String description;
//    @Field("views")
//    private int views;
    @Field("category")
    private List<CategoryObject> category;
//    @Field("rating")
//    private int rating;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Format> getFormat() {
        return format;
    }

    public void setFormat(List<Format> format) {
        this.format = format;
    }

    public List<CategoryObject> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryObject> category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", format=" + format +
                ", category=" + category +
                '}';
    }
}


