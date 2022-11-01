package com.bankaccount.application.rest.commands.dto;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BankAccountDto extends CompletableFuture<BankAccountDto> {

  private BigDecimal balance;

  private UUID accountId;

  private UUID userId;

  private Boolean active;

}
