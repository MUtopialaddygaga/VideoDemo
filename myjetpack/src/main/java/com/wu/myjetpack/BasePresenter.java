package com.wu.myjetpack;

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();
}
