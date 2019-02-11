package ua.dnepr.mytestapplication.presentation.ui.fragments;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import ua.dnepr.mytestapplication.data.models.ViewItem;
import ua.dnepr.mytestapplication.presentation.mvp.viewed.IViewedView;
import ua.dnepr.mytestapplication.presentation.mvp.viewed.PresenterViewed;
import ua.dnepr.mytestapplication.presentation.mvp.viewed.adapter.ViewedAdapter;
import ua.dnepr.mytestapplication.presentation.ui.DetailActivity;

public class ViewedFragment extends MvpAppCompatFragment implements IViewedView {
    @InjectPresenter
    PresenterViewed presenterViewed;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    ViewedAdapter viewedAdapter;
    @BindView(R.id.view_no_elements)
    RelativeLayout view_no_elements;
    @BindView(R.id.recyclerViewList)
    RecyclerView recyclerViewList;
    @BindView(R.id.swiprefresh)
    SwipeRefreshLayout swipeRefreshLayout;

    public ViewedFragment() {
    }

    public static ViewedFragment newInstance() {
        ViewedFragment frag = new ViewedFragment();
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
        swipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showNoNetworkLayout() {
        sendError(getString(R.string.no_internet));
    }

    @Override
    public void listPosts(List<ViewItem> viewItems) {
        viewedAdapter.clearItems();
        viewedAdapter.setItems(viewItems);
        if (viewItems.size() == 0) {
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
        viewedAdapter = new ViewedAdapter(viewItem ->  {
            DetailActivity.start(getActivity(),viewItem);
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerViewList.setLayoutManager(linearLayoutManager);
        recyclerViewList.setItemAnimator(new DefaultItemAnimator());
        recyclerViewList.setAdapter(viewedAdapter);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            presenterViewed.getMostViewed(false);
        });

        return rootView;
    }
}
