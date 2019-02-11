package ua.dnepr.mytestapplication.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import ua.dnepr.mytestapplication.data.network.ServerMethod;
import ua.dnepr.mytestapplication.di.module.ContextModule;
import ua.dnepr.mytestapplication.di.module.DataModule;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.PresenterEmailed;
import ua.dnepr.mytestapplication.presentation.mvp.shared.PresenterShared;
import ua.dnepr.mytestapplication.presentation.mvp.viewed.PresenterViewed;


@Singleton
@Component(modules = {ContextModule.class, DataModule.class})
public interface AppComponent {

    Context getContext();

    ServerMethod getAuthService();

    void inject(PresenterEmailed presenterEmailed);
    void inject(PresenterShared presenterShared);
    void inject(PresenterViewed presenterViewed);
}
