package ua.dnepr.mytestapplication.data.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SharedItem implements Serializable {
	@SerializedName("url")
	@NonNull
	private String url;
	@SerializedName("adx_keywords")
	@NonNull
	private String adxKeywords;
	@SerializedName("subsection")
	@NonNull
	private String subsection;
	@SerializedName("share_count")
	@NonNull
	private long shareCount;
	@SerializedName("count_type")
	@NonNull
	private String countType;
	@SerializedName("column")
	@NonNull
	private String column;
	@SerializedName("eta_id")
	@NonNull
	private long etaId;
	@SerializedName("section")
	@NonNull
	private String section;
	@SerializedName("id")
	@NonNull
	private long id;
	@SerializedName("asset_id")
	@NonNull
	private long assetId;
	@SerializedName("nytdsection")
	@NonNull
	private String nytdsection;
	@SerializedName("byline")
	@NonNull
	private String byline;
	@SerializedName("type")
	@NonNull
	private String type;
	@SerializedName("title")
	@NonNull
	private String title;
	@SerializedName("abstract")
	@NonNull
	private String _abstract;
	@SerializedName("published_date")
	@NonNull
	private String publishedDate;
	@SerializedName("source")
	@NonNull
	private String source;
	@SerializedName("updated")
	@NonNull
	private String updated;
	@SerializedName("des_facet")
	@NonNull
	private Object desFacet;
	@SerializedName("org_facet")
	@NonNull
	private Object orgFacet;
	@SerializedName("per_facet")
	@NonNull
	private Object perFacet;
	@SerializedName("geo_facet")
	@NonNull
	private Object geoFacet;
	@SerializedName("media")
	@NonNull
	private List<Medium> media = null;
	@SerializedName("uri")
	@NonNull
	private String uri;

	@NonNull
	public String getUrl() {
		return url;
	}

	public void setUrl(@NonNull String url) {
		this.url = url;
	}

	@NonNull
	public String getAdxKeywords() {
		return adxKeywords;
	}

	public void setAdxKeywords(@NonNull String adxKeywords) {
		this.adxKeywords = adxKeywords;
	}

	@NonNull
	public String getSubsection() {
		return subsection;
	}

	public void setSubsection(@NonNull String subsection) {
		this.subsection = subsection;
	}

	public long getShareCount() {
		return shareCount;
	}

	public void setShareCount(long shareCount) {
		this.shareCount = shareCount;
	}

	@NonNull
	public String getCountType() {
		return countType;
	}

	public void setCountType(@NonNull String countType) {
		this.countType = countType;
	}

	@NonNull
	public String getColumn() {
		return column;
	}

	public void setColumn(@NonNull String column) {
		this.column = column;
	}

	public long getEtaId() {
		return etaId;
	}

	public void setEtaId(long etaId) {
		this.etaId = etaId;
	}

	@NonNull
	public String getSection() {
		return section;
	}

	public void setSection(@NonNull String section) {
		this.section = section;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	@NonNull
	public String getNytdsection() {
		return nytdsection;
	}

	public void setNytdsection(@NonNull String nytdsection) {
		this.nytdsection = nytdsection;
	}

	@NonNull
	public String getByline() {
		return byline;
	}

	public void setByline(@NonNull String byline) {
		this.byline = byline;
	}

	@NonNull
	public String getType() {
		return type;
	}

	public void setType(@NonNull String type) {
		this.type = type;
	}

	@NonNull
	public String getTitle() {
		return title;
	}

	public void setTitle(@NonNull String title) {
		this.title = title;
	}

	@NonNull
	public String get_abstract() {
		return _abstract;
	}

	public void set_abstract(@NonNull String _abstract) {
		this._abstract = _abstract;
	}

	@NonNull
	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(@NonNull String publishedDate) {
		this.publishedDate = publishedDate;
	}

	@NonNull
	public String getSource() {
		return source;
	}

	public void setSource(@NonNull String source) {
		this.source = source;
	}

	@NonNull
	public String getUpdated() {
		return updated;
	}

	public void setUpdated(@NonNull String updated) {
		this.updated = updated;
	}

	@NonNull
	public Object getDesFacet() {
		return desFacet;
	}

	public void setDesFacet(@NonNull Object desFacet) {
		this.desFacet = desFacet;
	}

	@NonNull
	public Object getOrgFacet() {
		return orgFacet;
	}

	public void setOrgFacet(@NonNull Object orgFacet) {
		this.orgFacet = orgFacet;
	}

	@NonNull
	public Object getPerFacet() {
		return perFacet;
	}

	public void setPerFacet(@NonNull String perFacet) {
		this.perFacet = perFacet;
	}

	@NonNull
	public Object getGeoFacet() {
		return geoFacet;
	}

	public void setGeoFacet(@NonNull Object geoFacet) {
		this.geoFacet = geoFacet;
	}

	@NonNull
	public List<Medium> getMedia() {
		return media;
	}

	public void setMedia(@NonNull List<Medium> media) {
		this.media = media;
	}

	@NonNull
	public String getUri() {
		return uri;
	}

	public void setUri(@NonNull String uri) {
		this.uri = uri;
	}
}
