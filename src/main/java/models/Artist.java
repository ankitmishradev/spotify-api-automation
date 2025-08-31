package models;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"external_urls", "followers", "genres", "href", "id", "images", "name", "popularity", "type", "uri"})
public class Artist extends ResponseError {
    @JsonProperty("external_urls")
    private HashMap<String, String> externalUrls;
    @JsonProperty("followers")
    private HashMap<String, String> followers;
    @JsonProperty("genres")
    private ArrayList<String> genres;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("images")
    private ArrayList<HashMap<String, String>> images;
    @JsonProperty("name")
    private String name;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("type")
    private String type;
    @JsonProperty("uri")
    private String uri;
    @JsonProperty("error")
    private ResponseError error;
    @JsonIgnore
    private HashMap<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("external_urls")
    public HashMap<String, String> getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(HashMap<String, String> externalUrls) {
        this.externalUrls = externalUrls;
    }

    @JsonProperty("followers")
    public HashMap<String, String> getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(HashMap<String, String> followers) {
        this.followers = followers;
    }

    @JsonProperty("genres")
    public ArrayList<String> getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
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
    public ArrayList<HashMap<String, String>> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(ArrayList<HashMap<String, String>> images) {
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

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
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
    public HashMap<String, Object> getAdditionalProperties() {
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
        if (!super.equals(o)) return false;
        Artist artist = (Artist) o;
        return Objects.equals(externalUrls, artist.externalUrls) && (Objects.nonNull(error) || (Objects.nonNull(followers) && Objects.nonNull(artist.followers))) && Objects.equals(genres,
                artist.genres) && Objects.equals(href, artist.href) && Objects.equals(id, artist.id) && Objects.equals(images, artist.images) && Objects.equals(name, artist.name) && Objects.equals(popularity, artist.popularity) && Objects.equals(type, artist.type) && Objects.equals(uri, artist.uri) && Objects.equals(error, artist.error) && Objects.equals(additionalProperties, artist.additionalProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), externalUrls, followers, genres, href, id, images, name, popularity, type, uri, error, additionalProperties);
    }
}