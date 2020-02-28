package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.oneday.videodemo.jni.JniDemo;

public class MainActivity extends AppCompatActivity {
    private JniDemo demo = new JniDemo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String test = demo.printWord("who are you ????");
        demo.sayHelloWorld();
    }
}
