package com.glennbech.usda.resource;

import org.jooq.DSLContext;
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
    private DataSource dataSource;

    private static JdbcTemplate jdbcTemplate;
    private DSLContext dslContext;

    JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
            DataSource dataSource = (DataSource) context.getBean("dataSource");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

    DSLContext getContext() {
        if (dslContext == null) {
            ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
            return (DSLContext) context.getBean("dsl");
        }
        return dslContext;
    }

}
