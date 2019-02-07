package ua.dnepr.mytestapplication.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.dnepr.mytestapplication.data.network.GhostApiService;
import ua.dnepr.mytestapplication.data.network.ServerMethod;

@Module(includes = {ApiModule.class})
public class DataModule {
    @Provides
    @Singleton
    public ServerMethod provideGithubService(GhostApiService ghostApiService) {
        return new ServerMethod(ghostApiService);
    }
}
