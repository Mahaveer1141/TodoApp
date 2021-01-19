package com.example.app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.app.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDBHandler extends SQLiteOpenHelper {

    private final String DB_NAME = "todo_table";
    int ch = 0;

    public TodoDBHandler(@Nullable Context context) {
        super(context, "Todos", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + DB_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT)";
        db.execSQL(create);
    } 

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void addTodo(String task) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("task", task);
        db.insert(DB_NAME, null, values);
        db.close();
        ch++;
    }

    public List<Todo> getAllTodo() {
        List<Todo> todoList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String select = "SELECT * FROM " + DB_NAME;
        Cursor cursor = db.rawQuery(select, null);

        if (cursor.moveToFirst()) {
            do {
                String getId = cursor.getString(0);
                int _id = 0;
                if (getId != null) {
                    try {
                        _id = Integer.parseInt(getId);
                        ch = _id;
                    } catch (NumberFormatException e) {
                        _id = ch+1;
                    }
                }
                Todo todo = new Todo(_id, cursor.getString(1), false);
                todoList.add(todo);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return todoList;
    }

    public void updateTodo(int _id, String newTask) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("task", newTask);

        db.update(DB_NAME, values, "id =? ", new String[]{String.valueOf(_id)});
    }

    public void deleteTodo(int _id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME,"id =? ", new String[]{String.valueOf(_id)});
    }

}
