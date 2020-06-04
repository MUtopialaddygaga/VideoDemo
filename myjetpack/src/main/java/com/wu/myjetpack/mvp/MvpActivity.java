package com.wu.myjetpack.mvp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.wu.myjetpack.R;
import com.wu.myjetpack.databinding.ActivityMvpBinding;

import javax.inject.Inject;


public class MvpActivity extends Activity implements TestContract.ITestView {
    private static final String TAG = MvpActivity.class.getSimpleName();
    private ActivityMvpBinding mActivityMvpBinding;

    @Inject
    public TestPresenter testPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMvpBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvp);

    }


    @Override
    public void showToast(String tip) {

    }
}
