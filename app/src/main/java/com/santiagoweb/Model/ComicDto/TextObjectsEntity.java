package com.santiagoweb.Model.ComicDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TextObjectsEntity {
    @Expose
    @SerializedName("text")
    private String text;
    @Expose
    @SerializedName("language")
    private String language;
    @Expose
    @SerializedName("type")
    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
