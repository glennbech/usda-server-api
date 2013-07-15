package com.glennbech.usda.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

/**

 */
@JsonIgnoreProperties(ignoreUnknown = true )
public  class SearchResult<T> {

    private int totalResults ;
    private int currentPage;
    private int pageSize;
    private List<T> results ;


    @JsonInclude(JsonInclude.Include.ALWAYS)
    public int getTotalPages() {
        return totalResults/pageSize +1 ;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
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
}
