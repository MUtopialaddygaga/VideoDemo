package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.oneday.videodemo.databinding.ActivityMainBinding;
import com.oneday.videodemo.jni.JniDemo;
import com.oneday.videodemo.model.ItemModel;
import com.oneday.videodemo.recyclerviewdemo.CommonAdapter;
import com.oneday.videodemo.util.LogContants;
import com.oneday.videodemo.video.VideoActivity;
import com.oneday.videodemo.view.CustomViewActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private JniDemo demo = new JniDemo();
    private ActivityMainBinding mActivityMainBinding;
    private CommonAdapter<ItemModel> commonAdapter;
    private static List<ItemModel> mDatas = new ArrayList<>();

    static {
        ItemModel itemModel1 = new ItemModel();
        itemModel1.itemLabel = "导航";
        ItemModel itemModel2 = new ItemModel();
        itemModel2.itemLabel = "测试";
        ItemModel itemModel3 = new ItemModel();
        itemModel3.itemLabel = "自定义View";
        mDatas.add(itemModel1);
        mDatas.add(itemModel2);
        mDatas.add(itemModel3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        commonAdapter = new CommonAdapter<ItemModel>(mDatas, R.layout.activity_main_item, BR.itemModel);
        commonAdapter.setOnItemClick(listener);
        mActivityMainBinding.rvController.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mActivityMainBinding.rvController.setItemAnimator(new DefaultItemAnimator());
        mActivityMainBinding.rvController.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        mActivityMainBinding.rvController.setAdapter(commonAdapter);
        mActivityMainBinding.btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LogContants.TAG_DISPATCH_EVENT, "MainActivity-onClick, v :" + v.toString());
                Intent mIntent = new Intent(MainActivity.this, VideoActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mIntent);
            }
        });

    }

    CommonAdapter.ItemClickListener listener = new CommonAdapter.ItemClickListener() {
        @Override
        public void onItemClickListener(int item) {
            Log.e(TAG, "#####item ：" + item);
            switch (item){
                case 0:

                    break;
                case 1:

                    break;
                case 2:
                    launchActivity(CustomViewActivity.class);
                    break;
            }
        }
    };

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


    private void launchActivity(Class<?> clazz){
        Intent mIntent = new Intent(this, clazz);
        mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(mIntent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "MainActivity-dispatchTouchEvent, ev :" + ev.toString());
        return super.dispatchTouchEvent(ev);
        //return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(LogContants.TAG_DISPATCH_EVENT, "MainActivity-onTouchEvent, ev :" + event.toString());
        return super.onTouchEvent(event);
        //return true;
    }
}
