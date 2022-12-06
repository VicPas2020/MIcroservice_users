package com.SkillBox.users.testcontainers.config;

import com.SkillBox.users.testcontainers.containers.PostgresTestContainer;
import org.junit.ClassRule;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public class ContainersEnvironment {

    @Container
    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = PostgresTestContainer.getInstance();
}
