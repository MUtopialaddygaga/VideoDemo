package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.oneday.videodemo.databinding.ActivityMainBinding;
import com.oneday.videodemo.jni.JniDemo;
import com.oneday.videodemo.model.TestObservable;
import com.oneday.videodemo.tools.DateUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private JniDemo demo = new JniDemo();
    private ActivityMainBinding mActivityMainBinding;
    private TestObservable mTestBean;
    //private static int[] testData = new int[10];

//    static {
//        for (int i = 0; i < 10; i++){
//            testData[i] = i;
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mTestBean = new TestObservable(DateUtils.getCurrentTimeStamp(), "welcome to databinding");
        mActivityMainBinding.setMTestObservable(mTestBean);
        mActivityMainBinding.setMainactivity(new MainActivity());
        demo.setS("789");
        Log.d(TAG, "java set value, S :" + demo.getS() + ", si :" + JniDemo.si);
        demo.accessField();
        Log.d(TAG, "c set value, S :" + demo.getS() + ", si :" + JniDemo.si);
        demo.accessMethod();
        //点击事件处理方法一
//        mActivityMainBinding.btTest.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    /**
     * //点击事件处理方法二
     * 注意点
     * 1.必须用public修饰
     * 2.必须有VIEW作为参数
     */
    public void dealButtonClickEventOne(View view){
        Log.d(TAG, ">>>>>>>>>>>>>>dealButtonClickEvent<<<<<<<<<<<<");
    }

}
