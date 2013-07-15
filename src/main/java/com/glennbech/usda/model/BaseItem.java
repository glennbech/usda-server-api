package com.glennbech.usda.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.net.URI;
import java.util.List;

/**
 *
 *
 */

@JsonInclude (JsonInclude.Include.NON_NULL)
public class BaseItem {

    private List<URI> links;
    private String attribution = "U. S. Department of Agriculture." ;

    public List<URI> getLinks() {
        return links;
    }

    public void setLinks(List<URI> links) {
        this.links = links;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

}
