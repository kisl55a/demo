package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ToDoModel {

   private ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();

    void addNewTodoItem(ToDoItem item) {
        toDoItems.add(item);
    }

    public List<ToDoItem> getTodoItems() {
        return  toDoItems;
    }

}
