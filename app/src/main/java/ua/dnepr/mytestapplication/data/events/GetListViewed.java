package ua.dnepr.mytestapplication.data.events;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ua.dnepr.mytestapplication.data.models.SharedItem;
import ua.dnepr.mytestapplication.data.models.ViewItem;

public class GetListViewed implements Serializable {
	@SerializedName("status")
	private String status;
	@SerializedName("copyright")
	private String copyright;
	@SerializedName("num_results")
	@NonNull
	private int num_results;
	@SerializedName("results")
	private List<ViewItem> viewItems = null;


	public List<ViewItem> getViewItems() {
		return (viewItems != null) ? viewItems : new ArrayList<>();
	}

	public String getStatus() {
		return (status != null) ? status : "";
	}

	public String getCopyright() {
		return (copyright != null) ? copyright : "";
	}

	public int getNum_results() {
		return num_results;
	}
}
