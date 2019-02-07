package ua.dnepr.mytestapplication.data.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class EmailItem implements Serializable {

	@SerializedName("url")
	@NonNull
	private String url;
	@SerializedName("adx_keywords")
	@NonNull
	private String adxKeywords;
	@SerializedName("subsection")
	@NonNull
	private String subsection;
	@SerializedName("email_count")
	@NonNull
	private int emailCount;
	@SerializedName("count_type")
	@NonNull
	private String countType;
	@SerializedName("column")
	@NonNull
	private Object column;
	@SerializedName("eta_id")
	@NonNull
	private int etaId;
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
	private List<String> desFacet = null;
	@SerializedName("org_facet")
	@NonNull
	private Object orgFacet;
	@SerializedName("per_facet")
	@NonNull
	private List<String> perFacet = null;
	@SerializedName("geo_facet")
	@NonNull
	private String geoFacet;
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

	public int getEmailCount() {
		return emailCount;
	}

	public void setEmailCount(int emailCount) {
		this.emailCount = emailCount;
	}

	@NonNull
	public String getCountType() {
		return countType;
	}

	public void setCountType(@NonNull String countType) {
		this.countType = countType;
	}

	@NonNull
	public Object getColumn() {
		return column;
	}

	public void setColumn(@NonNull Object column) {
		this.column = column;
	}

	public int getEtaId() {
		return etaId;
	}

	public void setEtaId(int etaId) {
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
	public List<String> getDesFacet() {
		return desFacet;
	}

	public void setDesFacet(@NonNull List<String> desFacet) {
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
	public List<String> getPerFacet() {
		return perFacet;
	}

	public void setPerFacet(@NonNull List<String> perFacet) {
		this.perFacet = perFacet;
	}

	@NonNull
	public String getGeoFacet() {
		return geoFacet;
	}

	public void setGeoFacet(@NonNull String geoFacet) {
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
