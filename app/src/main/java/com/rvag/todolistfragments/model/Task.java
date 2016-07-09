package com.rvag.todolistfragments.model;

/**
 * Created by Robert on 09/07/2016.
 */
public class Task {

    public Task(String name, String image) {
        Name = name;
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    private String Name;
    private String Image;
}
