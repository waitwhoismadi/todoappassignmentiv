package com.example.todoappassignmentiv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> tasks;
    private ArrayAdapter<String> tasksAdapter;
    private ListView listViewTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTasks = (ListView) findViewById(R.id.listViewTasks);
        tasks = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(tasksAdapter);
        listViewListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void listViewListener() {
        listViewTasks.setOnItemClickListener(
                (parent, view, position, id) -> {
                    tasks.remove(position);
                    tasksAdapter.notifyDataSetChanged();
                }
        );
    }

    public void addItemController(View v) {
        EditText newItem = (EditText) findViewById(R.id.newItem);
        String itemText = newItem.getText().toString();

        if(TextUtils.isEmpty(itemText)) {
            newItem.setError("Please, fill the field");
            return;
        } else{
            tasksAdapter.add(itemText);
            newItem.setText("");
        }
    }
}