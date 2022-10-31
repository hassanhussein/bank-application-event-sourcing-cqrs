package com.bankaccount.application.service;

import com.bankaccount.application.rest.commands.dto.UserDto;
import com.bankaccount.application.commands.CreateUserCommand;
import java.util.UUID;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private CommandGateway commandGateway;

  public UserService(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  public String createUser(UserDto user) {

    CreateUserCommand createUserCommand =
        CreateUserCommand.builder()
            .userId(UUID.randomUUID())
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .phoneNumber(user.getPhoneNumber())
            .build();
   commandGateway.sendAndWait(createUserCommand);
    return  "saved";
  }

}
