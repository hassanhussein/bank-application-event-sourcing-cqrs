package com.bankaccount.application.rest.commands.dto;

import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserCreationDto {

  private UUID userId;

  private String firstName;

  private String lastName;

  private String phoneNumber;

}
