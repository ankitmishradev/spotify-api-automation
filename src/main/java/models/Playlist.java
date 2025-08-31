package models;

import com.fasterxml.jackson.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"collaborative", "description", "id", "name", "type", "public", "error"})
public class Playlist {
    @JsonProperty("collaborative")
    private boolean collaborative;
    @JsonProperty("description")
    private String description;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("public")
    private boolean _public;
    @JsonProperty("followers")
    private Map<String, ?> followers;
    @JsonProperty("error")
    private ResponseError error;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("collaborative")
    public boolean getCollaborative() {
        return collaborative;
    }

    @JsonProperty("collaborative")
    public void setCollaborative(boolean collaborative) {
        this.collaborative = collaborative;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("public")
    public boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(boolean _public) {
        this._public = _public;
    }

    @JsonProperty("followers")
    public Map<String, ?> getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Map<String, ?> followers) {
        this.followers = followers;
    }

    public ResponseError getError() {
        return error;
    }

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
        Playlist playlist = (Playlist) o;
        return Objects.equals(collaborative, playlist.collaborative) && Objects.equals(description,
                playlist.description) && (error != null || Objects.equals(id, "")) && (error != null || playlist.id.length() == 22) && Objects.equals(name,
                playlist.name) && Objects.equals(type, playlist.type) && Objects.equals(_public, playlist._public) && Objects.equals(error, playlist.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collaborative, description, id, name, type, _public, error);
    }
}