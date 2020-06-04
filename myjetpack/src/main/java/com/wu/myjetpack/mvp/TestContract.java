package com.wu.myjetpack.mvp;

import com.wu.myjetpack.BasePresenter;
import com.wu.myjetpack.BaseView;

public interface TestContract {

    public interface ITestView extends BaseView<ITestPresenter>{
        void showToast(String tip);
    }


    public interface ITestPresenter extends BasePresenter<ITestView>{

    }


}
