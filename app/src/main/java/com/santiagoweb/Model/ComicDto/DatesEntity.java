package com.santiagoweb.Model.ComicDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatesEntity {
    @Expose
    @SerializedName("date")
    private String date;
    @Expose
    @SerializedName("type")
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
