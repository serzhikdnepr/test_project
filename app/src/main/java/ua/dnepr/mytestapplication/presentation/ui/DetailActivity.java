package ua.dnepr.mytestapplication.presentation.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.data.models.EmailItem;
import ua.dnepr.mytestapplication.data.models.SharedItem;
import ua.dnepr.mytestapplication.data.models.ViewItem;
import ua.dnepr.mytestapplication.presentation.mvp.GlideApp;

public class DetailActivity extends AppCompatActivity {
	@BindView(R.id.toolbar)
	Toolbar toolbar;
	@BindView(R.id.text_descript)
	TextView text_descript;
	@BindView(R.id.imageView)
	ImageView imageView;
	@BindView(R.id.btn_site)
	Button btn_site;

	public static void start(Context context, Object o) {
		Intent starter = new Intent(context, DetailActivity.class);
		starter.putExtra("object", (Serializable) o);
		context.startActivity(starter);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		ButterKnife.bind(this);
		setSupportActionBar(toolbar);
		ActionBar actionBar = getSupportActionBar();
		if (actionBar != null) {
			actionBar.setDisplayHomeAsUpEnabled(true);
			actionBar.show();
		}
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		if (getIntent().getSerializableExtra("object") instanceof EmailItem) {
			EmailItem emailItem = (EmailItem) getIntent().getSerializableExtra("object");
			String url = emailItem.getMedia().get(0).getMediaMetadata().get(2).getUrl();
			ViewGroup.LayoutParams params = imageView.getLayoutParams();
			params.height = (int) (metrics.widthPixels*((float)emailItem.getMedia().get(0).getMediaMetadata().get(2).getHeight()/(float)emailItem.getMedia().get(0).getMediaMetadata().get(2).getWidth()));

			imageView.setLayoutParams(params);
			GlideApp.with(this)
					.load(url)
					.fitCenter()
					.placeholder(R.drawable.ic_launcher_background)
					.into(imageView);
			text_descript.setText(emailItem.get_abstract());
			btn_site.setOnClickListener(v -> {
				Uri address = Uri.parse(emailItem.getUrl());
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder()
						.setShowTitle(true);
				CustomTabsIntent customTabsIntent = builder.build();
				customTabsIntent.launchUrl(this, address);
			});
		}else if(getIntent().getSerializableExtra("object") instanceof SharedItem){
			SharedItem sharedItem = (SharedItem) getIntent().getSerializableExtra("object");
			String url = sharedItem.getMedia().get(0).getMediaMetadata().get(2).getUrl();
			ViewGroup.LayoutParams params = imageView.getLayoutParams();
			params.height = (int) (metrics.widthPixels*((float)sharedItem.getMedia().get(0).getMediaMetadata().get(2).getHeight()/(float)sharedItem.getMedia().get(0).getMediaMetadata().get(2).getWidth()));

			imageView.setLayoutParams(params);
			GlideApp.with(this)
					.load(url)
					.fitCenter()
					.placeholder(R.drawable.ic_launcher_background)
					.into(imageView);
			text_descript.setText(sharedItem.get_abstract());
			btn_site.setOnClickListener(v -> {
				Uri address = Uri.parse(sharedItem.getUrl());
				CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder()
						.setShowTitle(true);
				CustomTabsIntent customTabsIntent = builder.build();
				customTabsIntent.launchUrl(this, address);
			});
		}else if(getIntent().getSerializableExtra("object") instanceof ViewItem){
			ViewItem viewItem = (ViewItem) getIntent().getSerializableExtra("object");
			String url = viewItem.getMedia().get(0).getMediaMetadata().get(2).getUrl();
			ViewGroup.LayoutParams params = imageView.getLayoutParams();
			params.height = (int) (metrics.widthPixels*((float)viewItem.getMedia().get(0).getMediaMetadata().get(2).getHeight()/(float)viewItem.getMedia().get(0).getMediaMetadata().get(2).getWidth()));

			imageView.setLayoutParams(params);
			GlideApp.with(this)
					.load(url)
					.fitCenter()
					.placeholder(R.drawable.ic_launcher_background)
					.into(imageView);
			text_descript.setText(viewItem.get_abstract());
			btn_site.setOnClickListener(v -> {
				Uri address = Uri.parse(viewItem.getUrl());
				CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder()
						.setShowTitle(true);
				CustomTabsIntent customTabsIntent = builder.build();
				customTabsIntent.launchUrl(this, address);
			});
		}

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		int i = menuItem.getItemId();
		if (i == android.R.id.home) {
			onBackPressed();
			return true;
		} else {
			return super.onOptionsItemSelected(menuItem);
		}
	}
}
