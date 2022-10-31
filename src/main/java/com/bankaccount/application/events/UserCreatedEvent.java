package com.bankaccount.application.events;

import com.bankaccount.application.rest.commands.dto.UserDto;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent {

  private UUID userId;

  private String firstName;

  private String lastName;

  private String phoneNumber;

}
