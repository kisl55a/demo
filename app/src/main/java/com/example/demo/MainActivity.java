package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

//    ToDoModel model = new ToDoModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.addNewToDoItem).setOnClickListener(this);
        ListView listView = findViewById(R.id.todoListView);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addNewToDoItem){
            EditText editor = findViewById(R.id.todoEditor);
            String text = editor.getText().toString();
            ToDoItem newItem = new ToDoItem();
            newItem.setItemText(text);
            ToDoModel model = ToDoApplication.getModel(this);
            model.addNewTodoItem(newItem);
            updateListUi();
        }
    }

    private void updateListUi() {
        ToDoModel model = ToDoApplication.getModel(this);
        ListView listView = (ListView) findViewById(R.id.todoListView);
        ArrayList<String> itemTexts = new ArrayList<String>();
        for (int i = 0; i < model.getTodoItems().size(); i++) {
            itemTexts.add(model.getTodoItems().get(i).getItemText());
        }
        Log.d("array", itemTexts.get(0));
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemTexts);
        listView.setAdapter(itemsAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int index, long id) {
        Intent intent = new Intent(this, TodoItemViewActivity.class);
        startActivity(intent);
    }
}
