package com.santiagoweb.Model.ComicDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {


    @Expose
    @SerializedName("count")
    private int count;
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("limit")
    private int limit;
    @Expose
    @SerializedName("offset")
    private int offset;


    @SerializedName("results")
    @Expose
    private List<Comics> comicsList = null;

    public List<Comics> getComicsList() {
        return comicsList;
    }

    public void setComicsList(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
