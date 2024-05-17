package org.mskm.monolith;

import org.junit.jupiter.api.Test;
import org.mskm.monolith.configuration.TestContainersConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MonolithApplicationTests {
    public static void main(String[] args) {
        SpringApplication.from(MonolithApplication::main)
                .with(TestContainersConfiguration.class)
                .run(args);
    }


    @Test
    void contextLoads() {
    }

}
