package com.example.maylisw.listexamples;

import android.support.annotation.NonNull;

/**
 * Created by maylisw on 9/27/17.
 */

public class Books implements Comparable<Books>  {
    //model layer (knows nothing about android)
    private String name;
    private String author;
    private int resourceID, ranking;

    public Books(String name, String author, int resourceID, int ranking) {
        this.name = name;
        this.author = author;
        this.resourceID = resourceID;
        this.ranking = ranking;
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

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    /** potive if before, negative if after and 0 is the same
     *
     */
    public int compareTo(@NonNull Books other) {
        return this.getRanking() - other.getRanking();

    }
}
