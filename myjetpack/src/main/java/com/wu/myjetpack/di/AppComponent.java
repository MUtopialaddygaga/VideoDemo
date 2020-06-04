package com.wu.myjetpack.di;

import android.app.Application;

import com.wu.myjetpack.JetAppcation;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//AndroidSupportInjectionModule.class这个必须加，否则编译不通过
@Singleton
@Component(modules = {ActivityBindingModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<JetAppcation> {

    @Component.Builder
    interface builder{
        
        @BindsInstance
        AppComponent.builder application(Application application);

        AppComponent build();
    }
}
