package com.example.demo;

import java.util.Date;

public class ToDoItem {
    private String itemText;
    private Date creationTime = new Date();

    public Date getCreationTime() {
        return creationTime;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public String getItemText() {
        return itemText;
    }


}
