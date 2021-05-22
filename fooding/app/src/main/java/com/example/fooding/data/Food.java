package com.example.fooding.data;

import org.litepal.crud.LitePalSupport;

public class Food extends LitePalSupport {
    private String name;
    private String Store;
    private int id;     //30001
    private int price;
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

    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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


}
