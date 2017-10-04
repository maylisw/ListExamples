package com.example.maylisw.listexamples;

/**
 * Created by maylisw on 9/27/17.
 */

public class Books {
    //model layer (knows nothing about android)
    private String name;
    private String author;
    private int resourceID;

    public Books(String name, String author, int resourceID) {
        this.name = name;
        this.author = author;
        this.resourceID = resourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    @Override
    public String toString() {
        return name;
    }
}
