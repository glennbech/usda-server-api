package com.glennbech.usda.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.sql.DataSource;

/**
 *
 */

@Component
public class BaseResource {

    @Autowired
    private DataSource dataSource ;

    private static JdbcTemplate jdbcTemplate ;

    JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            System.out.println("datasource is " + dataSource);
            ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
            DataSource dataSource = (DataSource) context.getBean("dataSource");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }


    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


}
