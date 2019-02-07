package ua.dnepr.mytestapplication.aplication;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import ua.dnepr.mytestapplication.di.AppComponent;
import ua.dnepr.mytestapplication.di.DaggerAppComponent;
import ua.dnepr.mytestapplication.di.module.ContextModule;

public class App extends Application {
	private static AppComponent appComponent;
	private static App instance;


	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);

	}
	@Override
	public void onCreate() {
		super.onCreate();

		instance = this;
		appComponent = buildComponent();

	}

	public AppComponent buildComponent() {
		return DaggerAppComponent.builder()
				.contextModule(new ContextModule(this))
				.build();
	}

	public static Context getInstance() {
		return instance;
	}

	public static AppComponent getComponent() {
		return appComponent;
	}

}
