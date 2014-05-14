package com.leeprovoost.intl_postcode_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class ApplicationConfiguration extends Configuration {

    @JsonProperty
    @NotEmpty
    private String mongoHost;

    @Min(1)
    @Max(65535)
    @JsonProperty
    private int mongoPort;

    @JsonProperty
    @NotEmpty
    private String mongoDb;

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getMongoDb() {
        return mongoDb;
    }

}
