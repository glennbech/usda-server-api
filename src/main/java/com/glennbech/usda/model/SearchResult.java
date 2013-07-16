package com.glennbech.usda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**

 */
@JsonIgnoreProperties(ignoreUnknown = true )
public  class SearchResult<T> {

    private int currentPage;
    private int pageSize;
    private List<T> results ;

    private String attribution = "U. S. Department of Agriculture." ;

    @JsonInclude(JsonInclude.Include.ALWAYS)
    public int getTotalPages() {
        return getTotalResults()/pageSize +1 ;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @JsonInclude(JsonInclude.Include.ALWAYS)
    public int getTotalResults() {
        return results  != null ? results.size()  : 0 ;
    }

    public void setTotalResults(int totalResults) {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }
}
