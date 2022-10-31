package com.bankaccount.application.rest.commands.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

  private UUID userId;

  private String firstName;

  private String lastName;

  private String phoneNumber;

}
