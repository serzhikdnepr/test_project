package ua.dnepr.mytestapplication.data.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Medium implements Serializable {

	@SerializedName("type")
	@NonNull
	private String type;
	@SerializedName("subtype")
	@NonNull
	private String subtype;
	@SerializedName("caption")
	@NonNull
	private String caption;
	@SerializedName("copyright")
	@NonNull
	private String copyright;
	@SerializedName("approved_for_syndication")
	@NonNull
	private int approvedForSyndication;
	@SerializedName("media-metadata")
	@NonNull
	private List<MediaMetadatum> mediaMetadata = null;

	@NonNull
	public String getType() {
		return type;
	}

	public void setType(@NonNull String type) {
		this.type = type;
	}

	@NonNull
	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(@NonNull String subtype) {
		this.subtype = subtype;
	}

	@NonNull
	public String getCaption() {
		return caption;
	}

	public void setCaption(@NonNull String caption) {
		this.caption = caption;
	}

	@NonNull
	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(@NonNull String copyright) {
		this.copyright = copyright;
	}

	public int getApprovedForSyndication() {
		return approvedForSyndication;
	}

	public void setApprovedForSyndication(int approvedForSyndication) {
		this.approvedForSyndication = approvedForSyndication;
	}

	@NonNull
	public List<MediaMetadatum> getMediaMetadata() {
		return (mediaMetadata!=null)?mediaMetadata:new ArrayList<>();
	}

	public void setMediaMetadata(@NonNull List<MediaMetadatum> mediaMetadata) {
		this.mediaMetadata = mediaMetadata;
	}
}
