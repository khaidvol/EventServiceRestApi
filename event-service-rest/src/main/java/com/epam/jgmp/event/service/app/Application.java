package com.epam.jgmp.event.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.epam.jgmp.event.service")
@EntityScan("com.epam.jgmp.event.service.dto")
@EnableJpaRepositories(basePackages = "com.epam.jgmp.event.service.impl.repository")
public class Application {

  public static void main(String[] args) {
      SpringApplication.run(Application.class, args);
  }
}
