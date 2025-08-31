package models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AccessToken {
    @JsonProperty(value = "access_token", required = true)
    private String accessToken;

    @JsonProperty(value = "token_type", required = true)
    private String tokenType;

    @JsonProperty(value = "expires_in", required = true)
    private String expiresIn;

    @JsonProperty(value = "scope", required = true)
    private String scope;

    @JsonProperty(value="error")
    private String error;

    @JsonProperty(value = "error_description")
    private String errorDescription;

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public String getScope() {
        return scope;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccessToken that = (AccessToken) o;
        return Objects.equals(accessToken, that.accessToken) && Objects.equals(tokenType, that.tokenType) && Objects.equals(expiresIn, that.expiresIn) && Objects.equals(scope, that.scope) && Objects.equals(error, that.error) && Objects.equals(errorDescription, that.errorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, tokenType, expiresIn, scope, error, errorDescription);
    }
}