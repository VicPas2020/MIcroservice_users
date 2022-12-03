package com.SkillBox.users.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


@Component
public class SchemaConfig implements BeanPostProcessor {

    private final Logger log = LoggerFactory.getLogger("SchemaConfig");

    private final String schemaName = "users_scheme";

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!StringUtils.isEmpty(schemaName) && bean instanceof DataSource) {
            DataSource dataSource = (DataSource) bean;
            try (Connection conn = dataSource.getConnection();
                 Statement statement = conn.createStatement()) {
                log.info("Going to create DB schema '{}' if not exists.", schemaName);
                statement.execute("create schema if not exists " + schemaName);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to create schema '" + schemaName + "'", e);
            }
        }
        return bean;
    }
}