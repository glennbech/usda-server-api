package com.glennbech.usda.resource;

import com.glennbech.usda.model.BaseItem;
import com.glennbech.usda.model.SearchResult;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

import static com.glennbech.usda.Constants.DEFAULT_PAGE_SIZE;

/**
 *
 */
public class PagedQuery<T extends BaseItem> {

    private JdbcTemplate template;

    public SearchResult<T> query(String countSql, Object[] countArguments, String querySQL, Object[] queryArguments, RowMapper<T> rowMapper, int pageSize, int page) {

        pageSize = pageSize == 0 ? DEFAULT_PAGE_SIZE :  pageSize;

        SearchResult<T> results = new SearchResult<T>();
        results.setCurrentPage(page);
        results.setPageSize(pageSize);

        int count = template.queryForInt(countSql, countArguments);
        results.setTotalResults(count);
        List<T> items = template.query(querySQL, queryArguments, rowMapper);
        results.setResults(items);
        return results;
    }

    public PagedQuery(JdbcTemplate template) {
        this.template = template;
    }
}