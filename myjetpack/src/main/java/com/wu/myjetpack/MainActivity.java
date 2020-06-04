package com.wu.myjetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.print.PrinterId;
import android.view.View;

import com.wu.myjetpack.databinding.ActivityMainBinding;
import com.wu.myjetpack.mvp.MvpActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActivityMainBinding.setClickEvent(new OnClickEvent());
    }

    public class OnClickEvent{

        public void clickOne(View view){
            Intent mIntent = new Intent(MainActivity.this, MvpActivity.class);
            mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(mIntent);
        }
    }
}
