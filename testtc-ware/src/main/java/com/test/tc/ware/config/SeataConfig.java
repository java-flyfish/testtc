package com.test.tc.ware.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;


@Configuration
public class SeataConfig {

    @Autowired
    private DataSourceProperties properties;

    @Bean
    public DataSource dataSource() {

        HikariDataSource hikariDataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        if (StringUtils.hasText(properties.getName())) {
            hikariDataSource.setPoolName(properties.getName());
        }
        return new DataSourceProxy(hikariDataSource);
    }
}
