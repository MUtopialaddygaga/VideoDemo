package com.wu.myjetpack.mvp;

import javax.inject.Inject;

public class TestPresenter implements TestContract.ITestPresenter {

    /**
     * dagger在inject的时候，并不需要构造函数是public,因此，应该尽量使构造函数权限比较低，避免被其他开发者误实例化
     */
    @Inject
    TestPresenter() {

    }

    @Override
    public void takeView(TestContract.ITestView view) {

    }

    @Override
    public void dropView() {

    }
}
