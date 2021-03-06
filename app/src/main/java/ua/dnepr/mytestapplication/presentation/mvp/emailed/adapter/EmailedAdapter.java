package ua.dnepr.mytestapplication.presentation.mvp.emailed.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.dnepr.mytestapplication.R;
import ua.dnepr.mytestapplication.data.models.EmailItem;
import ua.dnepr.mytestapplication.presentation.mvp.GlideApp;

public class EmailedAdapter extends RecyclerView.Adapter<EmailedAdapter.EmailViewHolder> {

	private OnEmailClickListener onEmailClickListener;

	public EmailedAdapter(OnEmailClickListener onEmailClickListener) {
		this.onEmailClickListener = onEmailClickListener;
	}
	private List<EmailItem> emailItems = new ArrayList<>();

	@Override
	public EmailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.email_item_view, parent, false);
		return new EmailViewHolder(view);
	}

	@Override
	public void onBindViewHolder(EmailViewHolder holder, int position) {
		holder.bind(emailItems.get(position));
	}

	@Override
	public int getItemCount() {
		return emailItems.size();
	}

	public void setItems(Collection<EmailItem> tweets) {
		emailItems.addAll(tweets);
		notifyDataSetChanged();
	}

	public void clearItems() {
		emailItems.clear();
		notifyDataSetChanged();
	}

	class EmailViewHolder extends RecyclerView.ViewHolder {
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

		public EmailViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			itemView.setOnClickListener(v -> {
				EmailItem emailItem = emailItems.get(getLayoutPosition());
				onEmailClickListener.onEmailClick(emailItem);
			});
		}

		public void bind(EmailItem emailItem) {
			typeTextView.setText(emailItem.getType());
			content_text_view.setText(emailItem.getTitle());
			section_text_view.setText(emailItem.getSection());
			source_text_view.setText(emailItem.getSource());
			creationDateTextView.setText(emailItem.getPublishedDate());

			String url = emailItem.getMedia().get(0).getMediaMetadata().get(1).getUrl();

            GlideApp.with(itemView.getContext())
                    .load(url)
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(post_image_view);

		}


	}

	public interface OnEmailClickListener {
		void onEmailClick(EmailItem emailItem);
	}
}
