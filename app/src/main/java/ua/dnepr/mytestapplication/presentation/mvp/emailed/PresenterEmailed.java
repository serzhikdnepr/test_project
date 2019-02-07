package ua.dnepr.mytestapplication.presentation.mvp.emailed;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.aplication.App;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;
import ua.dnepr.mytestapplication.data.network.AppApiConstants;
import ua.dnepr.mytestapplication.data.network.ServerMethod;
import ua.dnepr.mytestapplication.presentation.mvp.BasePresenter;

@InjectViewState
public class PresenterEmailed extends BasePresenter<IEmailedView> {

	@Inject
	ServerMethod serverMethod;


	public PresenterEmailed() {
		App.getComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getMostEmailed(true);
	}

	public void getMostEmailed(boolean showProgress) {
		if (showProgress) {
			getViewState().showProgres();
		}
		final Single<GetListEmailed> observable = serverMethod.getListEmailedSingle();
		Disposable subscription = observable
				.subscribeOn(Schedulers.newThread())
				.retry(2)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(getListPoster -> {
					getViewState().hideProgres();
					if (getListPoster.getStatus().equalsIgnoreCase(AppApiConstants.STATUS_OK)) {
						getViewState().listPosts(getListPoster.getMediumList());
					}
				}, throwable -> {
					throwable.printStackTrace();
					getViewState().hideProgres();
				});
		unsubscribeOnDestroy(subscription);

	}
}
