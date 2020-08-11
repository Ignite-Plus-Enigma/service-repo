package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class SavedBook {
    @Field("book_id")
    private String bookId;
    @Field("format")
    private String format;
    @Field("progress")
    private String progress;
    @Field("is_finished")
    private String isFinished;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
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
                ", format='" + format + '\'' +
                ", progress='" + progress + '\'' +
                ", isFinished='" + isFinished + '\'' +
                '}';
    }
}
