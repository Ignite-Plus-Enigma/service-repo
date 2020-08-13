package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Progress {
    @Field("format")
    private String format;
    @Field("percentage")
    private int percentage;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "format='" + format + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
