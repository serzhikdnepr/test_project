package ua.dnepr.mytestapplication.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.data.models.EmailItem;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.IEmailedView;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.PresenterEmailed;
import ua.dnepr.mytestapplication.presentation.mvp.emailed.adapter.EmailedAdapter;

public class EmailedFragment extends MvpAppCompatFragment implements IEmailedView {
	@InjectPresenter
	PresenterEmailed presenterEmailed;
	@BindView(R.id.progress)
	ProgressBar progressBar;
	EmailedAdapter emailedAdapter;
	@BindView(R.id.view_no_elements)
	RelativeLayout view_no_elements;
	@BindView(R.id.recyclerViewList)
	RecyclerView recyclerViewList;

	public EmailedFragment() {
	}

	public static EmailedFragment newInstance() {
		EmailedFragment frag = new EmailedFragment();
		Bundle args = new Bundle();
		frag.setArguments(args);
		return frag;
	}

	@Override
	public void showProgres() {
		progressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideProgres() {
		progressBar.setVisibility(View.GONE);
	}

	@Override
	public void showNoNetworkLayout() {

	}

	@Override
	public void listPosts(List<EmailItem> emailItems) {

		emailedAdapter.setItems(emailItems);
		if (emailItems.size() == 0) {
			view_no_elements.setVisibility(View.VISIBLE);
		} else {
			view_no_elements.setVisibility(View.GONE);
		}
	}

	@Override
	public void sendError(String s) {
		Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.recyclerview, container, false);
		ButterKnife.bind(this, rootView);
		emailedAdapter=new EmailedAdapter();
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
		recyclerViewList.setLayoutManager(linearLayoutManager);
		recyclerViewList.setItemAnimator(new DefaultItemAnimator());
		recyclerViewList.setAdapter(emailedAdapter);
		return rootView;
	}
}
