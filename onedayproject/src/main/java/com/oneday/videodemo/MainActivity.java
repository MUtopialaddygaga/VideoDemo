package com.oneday.videodemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;

import com.oneday.videodemo.databinding.ActivityMainBinding;
import com.oneday.videodemo.jni.JniDemo;
import com.oneday.videodemo.jni.JniInterface;
import com.oneday.videodemo.model.ItemModel;
import com.oneday.videodemo.recyclerviewdemo.CommonAdapter;
import com.oneday.videodemo.reflect.ResultType;
import com.oneday.videodemo.reflect.TestClass;
import com.oneday.videodemo.util.LogContants;
import com.oneday.videodemo.video.VideoActivity;
import com.oneday.videodemo.view.CustomViewActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String TAG_JNI = "Jni-demo";
    //private JniDemo demo = new JniDemo();
    private ActivityMainBinding mActivityMainBinding;
    private CommonAdapter<ItemModel> commonAdapter;
    private static List<ItemModel> mDatas = new ArrayList<>();
    private JniInterface mJniInterface = new JniInterface();
    private int[] testData;

    private static final SparseArray<String> dispatcherFinder = new SparseArray<String>(256);
    private static SparseArray<String> finder;
    private static final Logger mLogger = Logger.getLogger("com.oneday.videodemo");

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

        Log.d(TAG, "================================================");
        Log.d(TAG, "dispatcherFinder :" + dispatcherFinder.hashCode());
        finder = dispatcherFinder;
        Log.d(TAG, "finder :" + finder.hashCode());
        Log.d(TAG, "================================================");

        studyReflect();

        mLogger.setLevel(Level.FINE);
    }

    /**
     * 学习jni
     */
    public void studyJni(){

        /*******************************native测试********************************/
        testData = new int[]{
                1,2,3,4,5,6,7,8,9,10
        };
        mJniInterface.sayHelloToJniWorld();
        Log.d(TAG_JNI, "version :" + mJniInterface.getVersion());
        mJniInterface.accessStringMethodOne("jniworld");
        Log.d(TAG_JNI, "result :" + mJniInterface.accessPrimitiveArray(testData));
        int[][] tmpData = mJniInterface.accessObjectArray(3);
        if (tmpData == null){
            Log.e(TAG_JNI, "err, tmpData == null");
            return;
        }
        for (int i = 0; i < tmpData.length; i++){
            for (int j = 0; j < tmpData.length; j++){
                Log.d(TAG_JNI, "current data :" + tmpData[i][j]);
            }
        }

        Log.d(TAG_JNI, "############测试native调用java层field并修改其值###########################");
        Log.d(TAG_JNI, "####修改前 :" + mJniInterface.getLocalStr());
        mJniInterface.accessJavaFiled();
        Log.d(TAG_JNI, "####修改后 :" + mJniInterface.getLocalStr());
        Log.d(TAG_JNI, "访问前 :" + mJniInterface.mStaticValue);
        Log.d(TAG_JNI, "访问静态field :" + mJniInterface.accessJavaStaticField());
        Log.d(TAG_JNI, "访问后 :" + mJniInterface.mStaticValue);
        Log.d(TAG_JNI, "############测试native调用java层field并修改其值###########################");

        mJniInterface.invokeCallbackBynative();
        /***************************************************************/

    }

    public void studyReflect(){
        TestClass testClass = new TestClass();

        Class cls = null;
        //获取class对象方式一
        //cls = testClass.getClass();
        try {
            //获取class对象方式二
            cls = Class.forName(TestClass.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (cls == null){
            return;
        }

        Class superCls = cls.getSuperclass();
        Annotation[] mArrAn = cls.getAnnotations();
        if (mArrAn != null && mArrAn.length > 0){
            for (Annotation ano : mArrAn){
                Log.d(TAG, ">>>>>>>>>>ano :" + ano.toString());
            }
        }

        Annotation tmpAno = cls.getAnnotation(ResultType.class);
        Log.d(TAG, ">>>>>>>>>tmpAno :" + tmpAno.toString());

        Constructor[] mConstructor = cls.getConstructors();
        if (mConstructor != null && mConstructor.length > 0){
            for (Constructor constructor : mConstructor){
                Log.d(TAG, "constructor :" + constructor.toString());
            }
        }


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
