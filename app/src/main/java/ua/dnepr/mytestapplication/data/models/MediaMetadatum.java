package ua.dnepr.mytestapplication.data.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MediaMetadatum implements Serializable {

	@SerializedName("url")
	@NonNull
	private String url;
	@SerializedName("format")
	@NonNull
	private String format;
	@SerializedName("height")
	@NonNull
	private int height;
	@SerializedName("width")
	@NonNull
	private int width;

	@NonNull
	public String getUrl() {
		return url;
	}

	public void setUrl(@NonNull String url) {
		this.url = url;
	}

	@NonNull
	public String getFormat() {
		return format;
	}

	public void setFormat(@NonNull String format) {
		this.format = format;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
