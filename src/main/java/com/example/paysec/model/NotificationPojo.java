package com.example.paysec.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "notification_type",
        "timestamp",
        "request_id",
        "asset_id",
        "public_id",
        "version",
        "version_id",
        "width",
        "height",
        "format",
        "resource_type",
        "created_at",
        "tags",
        "pages",
        "bytes",
        "type",
        "etag",
        "placeholder",
        "url",
        "secure_url",
        "coordinates",
        "original_filename",
        "eager",
        "api_key"
})
@Generated("jsonschema2pojo")
public class NotificationPojo {

    @JsonProperty("notification_type")
    private String notificationType;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("request_id")
    private String requestId;
    @JsonProperty("asset_id")
    private String assetId;
    @JsonProperty("public_id")
    private String publicId;
    @JsonProperty("version")
    private Integer version;
    @JsonProperty("version_id")
    private String versionId;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("format")
    private String format;
    @JsonProperty("resource_type")
    private String resourceType;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("tags")
    private List<Object> tags = null;
    @JsonProperty("pages")
    private Integer pages;
    @JsonProperty("bytes")
    private Integer bytes;
    @JsonProperty("type")
    private String type;
    @JsonProperty("etag")
    private String etag;
    @JsonProperty("placeholder")
    private Boolean placeholder;
    @JsonProperty("url")
    private String url;
    @JsonProperty("secure_url")
    private String secureUrl;
    @JsonProperty("coordinates")
    private Coordinates coordinates;
    @JsonProperty("original_filename")
    private String originalFilename;
    @JsonProperty("eager")
    private List<Eager> eager = null;
    @JsonProperty("api_key")
    private String apiKey;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("notification_type")
    public String getNotificationType() {
        return notificationType;
    }

    @JsonProperty("notification_type")
    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("request_id")
    public String getRequestId() {
        return requestId;
    }

    @JsonProperty("request_id")
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @JsonProperty("asset_id")
    public String getAssetId() {
        return assetId;
    }

    @JsonProperty("asset_id")
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    @JsonProperty("public_id")
    public String getPublicId() {
        return publicId;
    }

    @JsonProperty("public_id")
    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    @JsonProperty("version")
    public Integer getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonProperty("version_id")
    public String getVersionId() {
        return versionId;
    }

    @JsonProperty("version_id")
    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }

    @JsonProperty("resource_type")
    public String getResourceType() {
        return resourceType;
    }

    @JsonProperty("resource_type")
    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("tags")
    public List<Object> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    @JsonProperty("pages")
    public Integer getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

    @JsonProperty("bytes")
    public Integer getBytes() {
        return bytes;
    }

    @JsonProperty("bytes")
    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    @JsonProperty("placeholder")
    public Boolean getPlaceholder() {
        return placeholder;
    }

    @JsonProperty("placeholder")
    public void setPlaceholder(Boolean placeholder) {
        this.placeholder = placeholder;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("secure_url")
    public String getSecureUrl() {
        return secureUrl;
    }

    @JsonProperty("secure_url")
    public void setSecureUrl(String secureUrl) {
        this.secureUrl = secureUrl;
    }

    @JsonProperty("coordinates")
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("original_filename")
    public String getOriginalFilename() {
        return originalFilename;
    }

    @JsonProperty("original_filename")
    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
    }

    @JsonProperty("eager")
    public List<Eager> getEager() {
        return eager;
    }

    @JsonProperty("eager")
    public void setEager(List<Eager> eager) {
        this.eager = eager;
    }

    @JsonProperty("api_key")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("api_key")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
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
