package com.wu.myjetpack.mvp;

import com.wu.myjetpack.di.annotion.ActivityScope;
import com.wu.myjetpack.util.AppExecutors;
import com.wu.myjetpack.util.DiskIOThreadExecutor;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class TestModule {
    public static final int THREAD_COUNT = 3;

    @Singleton
    @Provides
    static AppExecutors provideAppExecutors() {
        return new AppExecutors(new DiskIOThreadExecutor(),
                Executors.newFixedThreadPool(THREAD_COUNT),
                new AppExecutors.MainThreadExecutor());
    }

    @ActivityScope
    @Binds
    public abstract TestContract.ITestPresenter getPresenter(TestPresenter presenter);
}
