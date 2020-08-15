package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class CategoryObject {

    @Field("main_category")
    private String mainCategory;
    @Field("sub_category")
    private List<String> subCategory;

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<String> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<String> subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "CategoryObject{" +
                "mainCategory='" + mainCategory + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
