package arabot.wiki.entity;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"pageid",
"ns",
"title",
"lat",
"lon",
"dist",
"primary"
})
public class Geosearch {

@Override
	public String toString() {
		return "Geosearch [pageid=" + pageid + ", ns=" + ns + ", title=" + title + ", lat=" + lat + ", lon=" + lon
				+ ", dist=" + dist + ", primary=" + primary + ", additionalProperties=" + additionalProperties
				+ ", getPageid()=" + getPageid() + ", getNs()=" + getNs() + ", getTitle()=" + getTitle() + ", getLat()="
				+ getLat() + ", getLon()=" + getLon() + ", getDist()=" + getDist() + ", getPrimary()=" + getPrimary()
				+ ", getAdditionalProperties()=" + getAdditionalProperties() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

@JsonProperty("pageid")
private String pageid;
@JsonProperty("ns")
private Integer ns;
@JsonProperty("title")
private String title;
@JsonProperty("lat")
private Double lat;
@JsonProperty("lon")
private Double lon;
@JsonProperty("dist")
private Double dist;
@JsonProperty("primary")
private String primary;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("pageid")
public String getPageid() {
return pageid;
}

@JsonProperty("pageid")
public void setPageid(String pageid) {
this.pageid = pageid;
}

@JsonProperty("ns")
public Integer getNs() {
return ns;
}

@JsonProperty("ns")
public void setNs(Integer ns) {
this.ns = ns;
}

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("lat")
public Double getLat() {
return lat;
}

@JsonProperty("lat")
public void setLat(Double lat) {
this.lat = lat;
}

@JsonProperty("lon")
public Double getLon() {
return lon;
}

@JsonProperty("lon")
public void setLon(Double lon) {
this.lon = lon;
}

@JsonProperty("dist")
public Double getDist() {
return dist;
}

@JsonProperty("dist")
public void setDist(Double dist) {
this.dist = dist;
}

@JsonProperty("primary")
public String getPrimary() {
return primary;
}

@JsonProperty("primary")
public void setPrimary(String primary) {
this.primary = primary;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}