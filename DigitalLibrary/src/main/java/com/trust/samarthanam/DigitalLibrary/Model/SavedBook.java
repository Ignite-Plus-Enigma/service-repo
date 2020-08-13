package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

public class SavedBook {
    @Field("book_id")
    private String bookId;
    @Field("progress")
    private List<Progress> progress;
    @Field("is_finished")
    private String isFinished;


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public List<Progress> getProgress() {
        return progress;
    }

    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public String toString() {
        return "SavedBook{" +
                "bookId='" + bookId + '\'' +
                ", progress=" + progress +
                ", isFinished='" + isFinished + '\'' +
                '}';
    }
}
