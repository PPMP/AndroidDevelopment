package com.patornp.rssfeedviewer;

/**
 * Created by Pongsanit on 6/27/16.
 */
public class RSSItem {

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Creator: " + getCreator() + "\n";
    }

    private String name;
    private String creator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
