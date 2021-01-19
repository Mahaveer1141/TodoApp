package com.example.app;

public class Todo {
    int mIndex;
    String mTask;
    boolean mIsDone;

    public Todo(int index, String task, boolean isDone) {
        mTask = task;
        mIsDone = isDone;
        mIndex = index;
    }

    public String getTask() {
        return mTask;
    }

    public String getIndex() {
        return (mIndex + "");
    }

    public boolean getIsDone() {
        return mIsDone;
    }

}
