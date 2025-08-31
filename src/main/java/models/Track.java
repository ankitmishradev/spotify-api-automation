package models;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"album", "artists", "available_markets", "disc_number", "duration_ms", "explicit", "external_ids", "external_urls", "href", "id", "is_local", "name", "popularity", "preview_url", "track_number", "type", "uri"})
public class Track {

    @JsonProperty("album")
    private Album album;
    @JsonProperty("artists")
    private List<Map<String, ?>> artists;
    @JsonProperty("available_markets")
    private List<String> availableMarkets;
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    @JsonProperty("explicit")
    private Boolean explicit;
    @JsonProperty("external_ids")
    private Map<String, String> externalIds;
    @JsonProperty("external_urls")
    private Map<String, String> externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("is_local")
    private Boolean isLocal;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("error")
    private ResponseError error;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    @JsonProperty("artists")
    public List<Map<String, ?>> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Map<String, ?>> artists) {
        this.artists = artists;
    }

    @JsonProperty("available_markets")
    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    @JsonProperty("available_markets")
    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    @JsonProperty("disc_number")
    public Integer getDiscNumber() {
        return discNumber;
    }

    @JsonProperty("disc_number")
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    @JsonProperty("duration_ms")
    public Integer getDurationMs() {
        return durationMs;
    }

    @JsonProperty("duration_ms")
    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    @JsonProperty("explicit")
    public Boolean getExplicit() {
        return explicit;
    }

    @JsonProperty("explicit")
    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    @JsonProperty("external_ids")
    public Map<String, String> getExternalIds() {
        return externalIds;
    }

    @JsonProperty("external_ids")
    public void setExternalIds(Map<String, String> externalIds) {
        this.externalIds = externalIds;
    }

    @JsonProperty("external_urls")
    public Map<String, String> getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(Map<String, String> externalUrls) {
        this.externalUrls = externalUrls;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("is_local")
    public Boolean getIsLocal() {
        return isLocal;
    }

    @JsonProperty("is_local")
    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("preview_url")
    public String getPreviewUrl() {
        return previewUrl;
    }

    @JsonProperty("preview_url")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    @JsonProperty("track_number")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @JsonProperty("track_number")
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("error")
    public ResponseError getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(ResponseError error) {
        this.error = error;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(album, track.album) && Objects.equals(artists, track.artists) && Objects.equals(availableMarkets, track.availableMarkets) && Objects.equals(discNumber, track.discNumber) && Objects.equals(durationMs, track.durationMs) && Objects.equals(explicit, track.explicit) && Objects.equals(externalIds, track.externalIds) && Objects.equals(externalUrls, track.externalUrls) && Objects.equals(href, track.href) && Objects.equals(id, track.id) && Objects.equals(isLocal, track.isLocal) && Objects.equals(name, track.name) && Objects.equals(popularity, track.popularity) && Objects.equals(previewUrl, track.previewUrl) && Objects.equals(trackNumber, track.trackNumber) && Objects.equals(type, track.type) && Objects.equals(uri, track.uri) && Objects.equals(error, track.error) && Objects.equals(additionalProperties, track.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(album, artists, availableMarkets, discNumber, durationMs, explicit, externalIds, externalUrls, href, id, isLocal, name, popularity, previewUrl, trackNumber, type, uri, error, additionalProperties);
    }
}