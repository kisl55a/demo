package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TodoItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_item_view);

        ToDoModel model = ToDoApplication.getModel(this);

        if (model.getTodoItems().size() > 2) {
            ToDoItem item = model.getTodoItems().get(2);
            TextView textView = findViewById(R.id.itemText);
            textView.setText(item.getItemText());

        }
    }
}
