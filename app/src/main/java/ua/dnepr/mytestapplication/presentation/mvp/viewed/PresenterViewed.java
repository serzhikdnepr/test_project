package ua.dnepr.mytestapplication.presentation.mvp.viewed;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ua.dnepr.mytestapplication.aplication.App;
import ua.dnepr.mytestapplication.data.events.GetListShared;
import ua.dnepr.mytestapplication.data.events.GetListViewed;
import ua.dnepr.mytestapplication.data.network.AppApiConstants;
import ua.dnepr.mytestapplication.data.network.ServerMethod;
import ua.dnepr.mytestapplication.domain.exceptions.NoNetworkException;
import ua.dnepr.mytestapplication.presentation.mvp.BasePresenter;
import ua.dnepr.mytestapplication.presentation.mvp.shared.ISharedView;

@InjectViewState
public class PresenterViewed extends BasePresenter<IViewedView> {

	@Inject
	ServerMethod serverMethod;


	public PresenterViewed() {
		App.getComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getMostViewed(true);
	}

	public void getMostViewed(boolean showProgress) {
		if (showProgress) {
			getViewState().showProgres();
		}
		final Single<GetListViewed> observable = serverMethod.getListViewedSingle();
		Disposable subscription = observable
				.subscribeOn(Schedulers.newThread())
				.retry(2)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(getListViewed ->  {
					getViewState().hideProgres();
					if (getListViewed.getStatus().equalsIgnoreCase(AppApiConstants.STATUS_OK)) {
						getViewState().listPosts(getListViewed.getViewItems());
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
