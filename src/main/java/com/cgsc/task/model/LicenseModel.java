package com.cgsc.task.model;

import com.cgsc.task.entity.License;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LicenseModel extends AbstractModel<License> {

    private String key;
    private String name;
    private String url;
    @JsonProperty("spdx_id")
    private String spdxId;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("html_url")
    private String htmlUrl;
}
