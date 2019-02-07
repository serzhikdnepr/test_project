package ua.dnepr.mytestapplication.presentation.mvp.emailed;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import ua.dnepr.mytestapplication.data.models.EmailItem;

public interface IEmailedView extends MvpView {
	void showProgres();
	void hideProgres();
	@StateStrategyType(SkipStrategy.class)
	void showNoNetworkLayout();

	void listPosts(List<EmailItem> emailItems);
	@StateStrategyType(SkipStrategy.class)
	void sendError(String s);
}
