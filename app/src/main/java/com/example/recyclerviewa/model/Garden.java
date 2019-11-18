package com.example.recyclerviewa.model;

public class Garden {
    private String name;
    private String category;
    private String description;
    private int thumbnail;

    public Garden() {
    }

    public Garden(String name, String category, String description, int thumbnail) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
