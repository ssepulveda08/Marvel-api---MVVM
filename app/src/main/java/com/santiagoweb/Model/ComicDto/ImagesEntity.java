package com.santiagoweb.Model.ComicDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImagesEntity {
    @Expose
    @SerializedName("extension")
    private String extension;
    @Expose
    @SerializedName("path")
    private String path;

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
