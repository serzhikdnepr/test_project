package ua.dnepr.mytestapplication.presentation.mvp.viewed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.data.models.ViewItem;
import ua.dnepr.mytestapplication.presentation.mvp.GlideApp;

public class ViewedAdapter extends RecyclerView.Adapter<ViewedAdapter.ViewViewHolder> {

	private OnViewClickListener onViewClickListener;

	public ViewedAdapter(OnViewClickListener onViewClickListener) {
		this.onViewClickListener = onViewClickListener;
	}
	private List<ViewItem> viewItems = new ArrayList<>();

	@Override
	public ViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.email_item_view, parent, false);
		return new ViewViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewViewHolder holder, int position) {
		holder.bind(viewItems.get(position));
	}

	@Override
	public int getItemCount() {
		return viewItems.size();
	}

	public void setItems(Collection<ViewItem> items) {
		viewItems.addAll(items);
		notifyDataSetChanged();
	}

	public void clearItems() {
		viewItems.clear();
		notifyDataSetChanged();
	}

	class ViewViewHolder extends RecyclerView.ViewHolder {
		@BindView(R.id.post_image_view)
		ImageView post_image_view;
		@BindView(R.id.type_text_view)
		TextView typeTextView;
		@BindView(R.id.creation_date_text_view)
		TextView creationDateTextView;
		@BindView(R.id.content_text_view)
		TextView content_text_view;
		@BindView(R.id.section_text_view)
		TextView section_text_view;
		@BindView(R.id.source_text_view)
		TextView source_text_view;

		public ViewViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			itemView.setOnClickListener(v -> {
				ViewItem viewItem = viewItems.get(getLayoutPosition());
				onViewClickListener.onViewClick(viewItem);
			});
		}

		public void bind(ViewItem viewItem) {
			typeTextView.setText(viewItem.getType());
			content_text_view.setText(viewItem.getTitle());
			section_text_view.setText(viewItem.getSection());
			source_text_view.setText(viewItem.getSource());
			creationDateTextView.setText(viewItem.getPublishedDate());

			String url = viewItem.getMedia().get(0).getMediaMetadata().get(1).getUrl();

            GlideApp.with(itemView.getContext())
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(post_image_view);

		}


	}

	public interface OnViewClickListener {
		void onViewClick(ViewItem viewItem);
	}
}
