package com.example.baitap;

public class BookmarkItem {
    private String title;
    private String description;
    private int imageResId; // ID của hình ảnh trong drawable
    private static boolean isSaved;

    public BookmarkItem(String title, String description, int imageResId) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.isSaved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    public static boolean isSaved() {
        return isSaved;
    }

    public static void setSaved(boolean saved) {
        isSaved = saved;
    }
}
