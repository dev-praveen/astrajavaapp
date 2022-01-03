package com.astra.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import java.io.File;

@Data
@ConfigurationProperties(prefix = "datastax.astra")
public class AstraDBConfig {

  private File secureConnectBundle;
}
