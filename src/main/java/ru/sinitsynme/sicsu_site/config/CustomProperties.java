package ru.sinitsynme.sicsu_site.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ru.sinitsynme")
public class CustomProperties {

  private String uploadPath;

  public String getUploadPath() {
    return uploadPath;
  }

  public void setUploadPath(String uploadPath) {
    this.uploadPath = uploadPath;
  }
}

//for future uploads of files