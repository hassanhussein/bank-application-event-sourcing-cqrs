package com.bankaccount.application.commands;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class OpenBankAccountCommand {

  private UUID userId;

  @TargetAggregateIdentifier
  private UUID accountId;

  private BigDecimal openingBalance;

  private Boolean active;

}
