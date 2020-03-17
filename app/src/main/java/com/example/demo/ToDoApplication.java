package com.example.demo;

import android.app.Activity;
import android.app.Application;

public class ToDoApplication extends Application {

    private ToDoModel model = null;

    @Override
    public void onCreate() {
        super.onCreate();
        model = new ToDoModel();
    }
   static public ToDoModel getModel(Activity activity) {
        ToDoApplication app = (ToDoApplication)activity.getApplication();
        return app.model;
    }
}
