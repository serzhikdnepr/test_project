package ua.dnepr.mytestapplication.presentation.mvp.shared;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ua.dnepr.mytestapplication.data.models.EmailItem;
import ua.dnepr.mytestapplication.data.models.SharedItem;

public interface ISharedView extends MvpView {
	void showProgres();
	void hideProgres();
	@StateStrategyType(SkipStrategy.class)
	void showNoNetworkLayout();

	void listPosts(List<SharedItem> sharedItems);
	@StateStrategyType(SkipStrategy.class)
	void sendError(String s);
}
