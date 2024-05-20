package org.mskm.monolith.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Configuration
@ComponentScan("org.mskm.monolith.domain.*")
@EnableReactiveMongoRepositories("org.mskm.monolith.domain.*")
public class DefaultConfig {
}
