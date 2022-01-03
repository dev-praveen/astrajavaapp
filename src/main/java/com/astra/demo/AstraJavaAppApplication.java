package com.astra.demo;

import com.astra.demo.config.AstraDBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CqlSessionBuilderCustomizer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
