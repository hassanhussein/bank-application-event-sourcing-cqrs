package com.bankaccount.application.events;

import com.bankaccount.application.model.User;
import com.bankaccount.application.repository.UserRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("application")
public class UserEventsHandler {

  @Autowired
  private UserRepository userRepository;

  @EventHandler
  public void on(UserCreatedEvent userCreatedEvent) throws Exception {

    User user = new User();
    BeanUtils.copyProperties(userCreatedEvent, user);
    userRepository.save(user);
    throw new Exception("Exception Occurred");
  }

  @ExceptionHandler
  public void handle(Exception exception) throws Exception {
    throw exception;
  }

}
