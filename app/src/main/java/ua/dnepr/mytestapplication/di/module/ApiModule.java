package ua.dnepr.mytestapplication.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import ua.dnepr.mytestapplication.data.network.GhostApiService;

@Module(includes = {RetrofitModule.class,OkHttpInterceptorsModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public GhostApiService provideAuthApi(Retrofit retrofit) {
        return retrofit.create(GhostApiService.class);
    }
}
