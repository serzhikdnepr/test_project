package ua.dnepr.mytestapplication.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ua.dnepr.mytestapplication.data.network.ServerMethod;
import ua.dnepr.mytestapplication.di.module.ContextModule;
import ua.dnepr.mytestapplication.di.module.DataModule;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.PresenterEmailed;


@Singleton
@Component(modules = {ContextModule.class, DataModule.class})
public interface AppComponent {

    Context getContext();

    ServerMethod getAuthService();

    void inject(PresenterEmailed presenterEmailed);
}
