package com.santiagoweb.Model.ComicDto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Comics {

    @Expose
    @SerializedName("images")
    private List<ImagesEntity> images;
    @Expose
    @SerializedName("dates")
    private List<DatesEntity> dates;
    @Expose
    @SerializedName("textObjects")
    private List<TextObjectsEntity> textObjects;
    @Expose
    @SerializedName("pageCount")
    private int pageCount;
    @Expose
    @SerializedName("format")
    private String format;
    @Expose
    @SerializedName("issn")
    private String issn;
    @Expose
    @SerializedName("ean")
    private String ean;
    @Expose
    @SerializedName("diamondCode")
    private String diamondCode;
    @Expose
    @SerializedName("upc")
    private String upc;
    @Expose
    @SerializedName("isbn")
    private String isbn;
    @Expose
    @SerializedName("modified")
    private String modified;
    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("variantDescription")
    private String variantDescription;
    @Expose
    @SerializedName("issueNumber")
    private int issueNumber;
    @Expose
    @SerializedName("title")
    private String title;
    @Expose
    @SerializedName("digitalId")
    private int digitalId;
    @Expose
    @SerializedName("id")
    private int id;

    public List<ImagesEntity> getImages() {
        return images;
    }

    public void setImages(List<ImagesEntity> images) {
        this.images = images;
    }

    public List<DatesEntity> getDates() {
        return dates;
    }

    public void setDates(List<DatesEntity> dates) {
        this.dates = dates;
    }

    public List<TextObjectsEntity> getTextObjects() {
        return textObjects;
    }

    public void setTextObjects(List<TextObjectsEntity> textObjects) {
        this.textObjects = textObjects;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public void setVariantDescription(String variantDescription) {
        this.variantDescription = variantDescription;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDigitalId() {
        return digitalId;
    }

    public void setDigitalId(int digitalId) {
        this.digitalId = digitalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
