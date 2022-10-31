package com.bankaccount.application;

import com.bankaccount.application.exception.EventsErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  private final static Logger LOG = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) {
    LOG.info("Running the application");
    SpringApplication.run(Application.class, args);

  }

  @Autowired
  public void configure(EventProcessingConfigurer processingConfigurer) {
    processingConfigurer.registerListenerInvocationErrorHandler("application",
        configuration -> new EventsErrorHandler());
  }

}
