package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.data.TodoDBHandler;

public class DoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        TodoDBHandler db = new TodoDBHandler(DoneActivity.this);

        EditText editText = findViewById(R.id.task);
        Button save = findViewById(R.id.submit_button);
        Button delete = findViewById(R.id.delete);
        String passedArg = getIntent().getExtras().getString("arg");
        String[] args = passedArg.split("with");
        editText.setText(args[0]);
        int id = Integer.parseInt(args[1]);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = editText.getText().toString();
                db.updateTodo(id, newTask);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteTodo(id);
                finish();
            }
        });
    }
}