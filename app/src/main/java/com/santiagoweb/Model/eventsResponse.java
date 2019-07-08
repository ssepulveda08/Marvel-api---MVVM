package com.santiagoweb.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class eventsResponse {

    @Expose
    @SerializedName("data")
    private DataEntity data;
    @Expose
    @SerializedName("etag")
    private String etag;
    @Expose
    @SerializedName("attributionHTML")
    private String attributionHTML;
    @Expose
    @SerializedName("attributionText")
    private String attributionText;
    @Expose
    @SerializedName("copyright")
    private String copyright;
    @Expose
    @SerializedName("status")
    private String status;
    @Expose
    @SerializedName("code")
    private int code;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class DataEntity {
        @Expose
        @SerializedName("results")
        private List<ResultsEntity> results;
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

        public List<ResultsEntity> getResults() {
            return results;
        }

        public void setResults(List<ResultsEntity> results) {
            this.results = results;
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

    public static class ResultsEntity {
        @Expose
        @SerializedName("thumbnail")
        private ThumbnailEntity thumbnail;
        @Expose
        @SerializedName("end")
        private String end;
        @Expose
        @SerializedName("start")
        private String start;
        @Expose
        @SerializedName("modified")
        private String modified;
        @Expose
        @SerializedName("resourceURI")
        private String resourceURI;
        @Expose
        @SerializedName("description")
        private String description;
        @Expose
        @SerializedName("title")
        private String title;
        @Expose
        @SerializedName("id")
        private int id;

        public ThumbnailEntity getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(ThumbnailEntity thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public String getResourceURI() {
            return resourceURI;
        }

        public void setResourceURI(String resourceURI) {
            this.resourceURI = resourceURI;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public static class ThumbnailEntity {
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
}
