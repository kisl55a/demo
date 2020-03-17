package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ArrayList<ToDoItem> toDoItems = new ArrayList<ToDoItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addNewToDoItem).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addNewToDoItem){
            EditText editor = findViewById(R.id.todoEditor);
            String text = editor.getText().toString();
            ToDoItem newItem = new ToDoItem();
            newItem.setItemText(text);
            toDoItems.add(newItem);
            updateListUi();
        }
    }

    private void updateListUi() {
        ListView listView = (ListView) findViewById(R.id.todoListView);
        ArrayList<String> itemTexts = new ArrayList<String>();
        for (int i = 0; i < toDoItems.size(); i++) {
            itemTexts.add(toDoItems.get(i).getItemText());
        }
        Log.d("array", itemTexts.get(0));
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemTexts);
        listView.setAdapter(itemsAdapter);
    }
}
