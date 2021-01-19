package com.example.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {

    public TodoAdapter(@NonNull Context context, List<Todo> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if(currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.list_layout, parent, false);
        }

        Todo current = getItem(position);

        TextView textView = currentView.findViewById(R.id.task);
        textView.setText(current.getTask());

        TextView index = currentView.findViewById(R.id.row_index_key);
        index.setText(current.getIndex()+". ");

        return currentView;
    }
}
