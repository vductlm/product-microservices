package com.ductlmse.microservice.core.review;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
public class SampleTest {

    @Container
    private static MySQLContainer database = new MySQLContainer("mysql:9.2.0");

}
