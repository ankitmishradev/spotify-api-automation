package models;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"album_type", "total_tracks", "available_markets", "external_urls", "href", "id", "images", "name", "release_date", "release_date_precision", "type", "uri", "artists", "tracks", "copyrights", "external_ids", "genres", "label", "popularity"})

public class Album {

    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("available_markets")
    private List<Object> availableMarkets;
    @JsonProperty("external_urls")
    private Map<String, String> externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private List<Map<String, String>> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("artists")
    private List<Object> artists;
    @JsonProperty("copyrights")
    private List<Map<String, String>> copyrights;
    @JsonProperty("external_ids")
    private Map<String, String> externalIds;
    @JsonProperty("genres")
    private List<Object> genres;
    @JsonProperty("label")
    private String label;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("error")
    private ResponseError error;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("album_type")
    public String getAlbumType() {
        return albumType;
    }

    @JsonProperty("album_type")
    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    @JsonProperty("total_tracks")
    public Integer getTotalTracks() {
        return totalTracks;
    }

    @JsonProperty("total_tracks")
    public void setTotalTracks(Integer totalTracks) {
        this.totalTracks = totalTracks;
    }

    @JsonProperty("available_markets")
    public List<Object> getAvailableMarkets() {
        return availableMarkets;
    }

    @JsonProperty("available_markets")
    public void setAvailableMarkets(List<Object> availableMarkets) {
        this.availableMarkets = availableMarkets;
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

    @JsonProperty("images")
    public List<Map<String, String>> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Map<String, String>> images) {
        this.images = images;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("release_date_precision")
    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    @JsonProperty("release_date_precision")
    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
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

    @JsonProperty("artists")
    public List<Object> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Object> artists) {
        this.artists = artists;
    }

    @JsonProperty("copyrights")
    public List<Map<String, String>> getCopyrights() {
        return copyrights;
    }

    @JsonProperty("copyrights")
    public void setCopyrights(List<Map<String, String>> copyrights) {
        this.copyrights = copyrights;
    }

    @JsonProperty("external_ids")
    public Map<String, String> getExternalIds() {
        return externalIds;
    }

    @JsonProperty("external_ids")
    public void setExternalIds(Map<String, String> externalIds) {
        this.externalIds = externalIds;
    }

    @JsonProperty("genres")
    public List<Object> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(List<Object> genres) {
        this.genres = genres;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
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
        Album album = (Album) o;
        //TODO: Not validate tracks field here.
        return Objects.equals(albumType, album.albumType) && Objects.equals(totalTracks, album.totalTracks) && Objects.equals(availableMarkets, album.availableMarkets) && Objects.equals(externalUrls, album.externalUrls) && Objects.equals(href, album.href) && Objects.equals(id, album.id) && Objects.equals(images, album.images) && Objects.equals(name, album.name) && Objects.equals(releaseDate, album.releaseDate) && Objects.equals(releaseDatePrecision, album.releaseDatePrecision) && Objects.equals(type, album.type) && Objects.equals(uri, album.uri) && Objects.equals(artists, album.artists) && Objects.equals(copyrights, album.copyrights) && Objects.equals(externalIds, album.externalIds) && Objects.equals(genres, album.genres) && Objects.equals(label, album.label) && Objects.equals(popularity, album.popularity) && Objects.equals(error, album.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumType, totalTracks, availableMarkets, externalUrls, href, id, images, name, releaseDate, releaseDatePrecision, type, uri, artists, copyrights, externalIds, genres, label, popularity, error, additionalProperties);
    }

}