package com.SkillBox.users.testcontainers.containers;

import org.junit.ClassRule;
import org.junit.Rule;
import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer extends PostgreSQLContainer<PostgresTestContainer> {

    public static final String IMAGE_VERSION = "postgres:14";
    public static final String DATABASE_NAME = "users";
    public static PostgreSQLContainer container;

    public PostgresTestContainer() {
        super(IMAGE_VERSION);
    }

    @Rule
    public static PostgreSQLContainer getInstance() {
        if (container == null) {
            container = new PostgresTestContainer().withDatabaseName(DATABASE_NAME);
        }
        return container;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("_------------------------------------------------------------------");
        System.out.println(container.getContainerId());
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @Override
    public void stop() {
        container.getDockerClient().killContainerCmd(container.getContainerId());
    }
}
