package com.trust.samarthanam.DigitalLibrary.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Format {
    @Field("type")
    private String type;
    @Field("url")
    private String url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Format{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
