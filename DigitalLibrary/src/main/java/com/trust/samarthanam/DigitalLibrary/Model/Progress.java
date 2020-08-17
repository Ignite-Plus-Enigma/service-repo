package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Progress {
    @Field("format")
    private String format;
    @Field("length")
    private long length;//length
    @Field("remaining")
    private long remaining;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public long getRemaining() {
        return remaining;
    }

    public void setRemaining(long remaining) {
        this.remaining = remaining;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "format='" + format + '\'' +
                ", length=" + length +
                ", remaining=" + remaining +
                '}';
    }
}
