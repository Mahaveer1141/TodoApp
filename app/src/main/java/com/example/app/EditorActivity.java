package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app.data.TodoDBHandler;

import java.util.ArrayList;

public class EditorActivity extends AppCompatActivity {

    private String task = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        TodoDBHandler db = new TodoDBHandler(EditorActivity.this);

        Button button = findViewById(R.id.submit_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.task);
                task = editText.getText().toString();
                editText.setText("");
                db.addTodo(task);
                finish();
            }
        });

    }

}
