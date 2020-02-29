package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.oneday.videodemo.jni.JniDemo;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private JniDemo demo = new JniDemo();
    //private static int[] testData = new int[10];

//    static {
//        for (int i = 0; i < 10; i++){
//            testData[i] = i;
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        demo.setS("789");
        Log.d(TAG, "java set value, S :" + demo.getS());
        demo.accessField();
        Log.d(TAG, "c set value, S :" + demo.getS());
    }
}
