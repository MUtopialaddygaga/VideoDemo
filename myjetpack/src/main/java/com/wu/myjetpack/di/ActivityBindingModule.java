package com.wu.myjetpack.di;

import com.wu.myjetpack.di.annotion.ActivityScope;
import com.wu.myjetpack.mvp.MvpActivity;
import com.wu.myjetpack.mvp.TestModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = TestModule.class)
    abstract MvpActivity addActivity();
}
