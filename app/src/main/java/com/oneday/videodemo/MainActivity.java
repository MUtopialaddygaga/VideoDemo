package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.oneday.videodemo.databinding.ActivityMainBinding;
import com.oneday.videodemo.jni.JniDemo;
import com.oneday.videodemo.model.TestBean;
import com.oneday.videodemo.tools.DateUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private JniDemo demo = new JniDemo();
    private ActivityMainBinding mActivityMainBinding;
    private TestBean mTestBean;
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
        mTestBean = new TestBean("");
        demo.setS("789");
        Log.d(TAG, "java set value, S :" + demo.getS() + ", si :" + JniDemo.si);
        demo.accessField();
        Log.d(TAG, "c set value, S :" + demo.getS() + ", si :" + JniDemo.si);
        demo.accessMethod();
    }
}
