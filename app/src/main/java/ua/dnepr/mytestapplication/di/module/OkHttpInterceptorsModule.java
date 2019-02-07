package ua.dnepr.mytestapplication.di.module;


import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.logging.HttpLoggingInterceptor;
import ua.dnepr.mytestapplication.di.qualifiers.OkHttpInterceptors;
import ua.dnepr.mytestapplication.di.qualifiers.OkHttpNetworkInterceptors;

import static java.util.Collections.singletonList;


@Module
public class OkHttpInterceptorsModule {

    @Provides
    @OkHttpInterceptors
    @Singleton
    @NonNull
    public List<Interceptor> provideOkHttpInterceptors() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return singletonList(httpLoggingInterceptor);
    }

    @Provides
    @OkHttpNetworkInterceptors
    @Singleton @NonNull
    public List<Interceptor> provideOkHttpNetworkInterceptors() {
        return singletonList(new StethoInterceptor());
    }

}