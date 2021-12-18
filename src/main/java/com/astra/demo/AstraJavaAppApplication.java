package com.astra.demo;

import com.astra.demo.config.AstraDBConfig;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.nio.file.Path;

@SpringBootApplication
// @Import(AstraDBConfig.class)
@EnableConfigurationProperties(AstraDBConfig.class)
public class AstraJavaAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(AstraJavaAppApplication.class, args);
  }

  @Bean
  public CqlSessionBuilderCustomizer sessionBuilderCustomizer(AstraDBConfig astraDBConfig) {

    final var path = astraDBConfig.getSecureConnectBundle().toPath();
    return cqlSessionBuilder ->
        cqlSessionBuilder.withCloudSecureConnectBundle(path).withKeyspace("fuel");
  }
}
