package ua.dnepr.mytestapplication.presentation.mvp.shared;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.dnepr.mytestapplication.aplication.App;
import ua.dnepr.mytestapplication.data.events.GetListEmailed;
import ua.dnepr.mytestapplication.data.events.GetListShared;
import ua.dnepr.mytestapplication.data.network.AppApiConstants;
import ua.dnepr.mytestapplication.data.network.ServerMethod;
import ua.dnepr.mytestapplication.domain.exceptions.NoNetworkException;
import ua.dnepr.mytestapplication.presentation.mvp.BasePresenter;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.IEmailedView;

@InjectViewState
public class PresenterShared extends BasePresenter<ISharedView> {

	@Inject
	ServerMethod serverMethod;


	public PresenterShared() {
		App.getComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getMostShared(true);
	}

	public void getMostShared(boolean showProgress) {
		if (showProgress) {
			getViewState().showProgres();
		}
		final Single<GetListShared> observable = serverMethod.getListSharedSingle();
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
					if (throwable instanceof NoNetworkException) {
						getViewState().showNoNetworkLayout();
					}
				});
		unsubscribeOnDestroy(subscription);

	}
}
