package com.oneday.videodemo.reflect;

public class TestClass {
    @ResultType(id = 123)
    public int currentId;

    public void setCurrentId(int currentId) {
        this.currentId = currentId;
    }

    public int getCurrentId() {
        return currentId;
    }
}
