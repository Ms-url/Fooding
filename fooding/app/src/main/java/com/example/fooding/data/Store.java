package com.example.fooding.data;

import org.litepal.crud.LitePalSupport;

public class Store extends LitePalSupport {
    private String name;
    private String up;
    private int id;     //20001
    private String color;
    private String background;
    private int mod;
    private int count;
    private int count_like;
    private int count_dislike;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_like() {
        return count_like;
    }

    public void setCount_like(int count_like) {
        this.count_like = count_like;
    }

    public int getCount_dislike() {
        return count_dislike;
    }

    public void setCount_dislike(int count_dislike) {
        this.count_dislike = count_dislike;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

}
