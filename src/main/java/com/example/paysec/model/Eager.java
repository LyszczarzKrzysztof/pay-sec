package com.example.paysec.model;

import java.util.HashMap;
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
        "transformation",
        "width",
        "height",
        "bytes",
        "format",
        "url",
        "secure_url"
})
@Generated("jsonschema2pojo")
public class Eager {

    @JsonProperty("transformation")
    private String transformation;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("bytes")
    private Integer bytes;
    @JsonProperty("format")
    private String format;
    @JsonProperty("url")
    private String url;
    @JsonProperty("secure_url")
    private String secureUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("transformation")
    public String getTransformation() {
        return transformation;
    }

    @JsonProperty("transformation")
    public void setTransformation(String transformation) {
        this.transformation = transformation;
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

    @JsonProperty("bytes")
    public Integer getBytes() {
        return bytes;
    }

    @JsonProperty("bytes")
    public void setBytes(Integer bytes) {
        this.bytes = bytes;
    }

    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
