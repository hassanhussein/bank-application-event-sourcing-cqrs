package com.bankaccount.application.commands;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class UpdateUserCommand {

  @TargetAggregateIdentifier
  private UUID userId;

  private String firstName;

  private String lastName;

  private String phoneNumber;

}
