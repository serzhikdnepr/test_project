package ua.dnepr.mytestapplication.presentation.mvp.shared.adapter;

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
import ua.dnepr.mytestapplication.data.models.EmailItem;
import ua.dnepr.mytestapplication.data.models.SharedItem;
import ua.dnepr.mytestapplication.presentation.mvp.GlideApp;

public class SharedAdapter extends RecyclerView.Adapter<SharedAdapter.ShareViewHolder> {

	private OnShareClickListener onShareClickListener;

	public SharedAdapter(OnShareClickListener onShareClickListener) {
		this.onShareClickListener = onShareClickListener;
	}
	private List<SharedItem> sharedItems = new ArrayList<>();

	@Override
	public ShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.email_item_view, parent, false);
		return new ShareViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ShareViewHolder holder, int position) {
		holder.bind(sharedItems.get(position));
	}

	@Override
	public int getItemCount() {
		return sharedItems.size();
	}

	public void setItems(Collection<SharedItem> items) {
		sharedItems.addAll(items);
		notifyDataSetChanged();
	}

	public void clearItems() {
		sharedItems.clear();
		notifyDataSetChanged();
	}

	class ShareViewHolder extends RecyclerView.ViewHolder {
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

		public ShareViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			itemView.setOnClickListener(v -> {
				SharedItem sharedItem = sharedItems.get(getLayoutPosition());
				onShareClickListener.onShareClick(sharedItem);
			});
		}

		public void bind(SharedItem sharedItem) {
			typeTextView.setText(sharedItem.getType());
			content_text_view.setText(sharedItem.getTitle());
			section_text_view.setText(sharedItem.getSection());
			source_text_view.setText(sharedItem.getSource());
			creationDateTextView.setText(sharedItem.getPublishedDate());

			String url = sharedItem.getMedia().get(0).getMediaMetadata().get(1).getUrl();

            GlideApp.with(itemView.getContext())
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(post_image_view);

		}


	}

	public interface OnShareClickListener {
		void onShareClick(SharedItem sharedItem);
	}
}
