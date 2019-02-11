package ua.dnepr.mytestapplication.presentation.mvp.viewed;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ua.dnepr.mytestapplication.data.models.ViewItem;

public interface IViewedView extends MvpView {
	void showProgres();
	void hideProgres();
	@StateStrategyType(SkipStrategy.class)
	void showNoNetworkLayout();

	void listPosts(List<ViewItem> viewItems);
	@StateStrategyType(SkipStrategy.class)
	void sendError(String s);
}
