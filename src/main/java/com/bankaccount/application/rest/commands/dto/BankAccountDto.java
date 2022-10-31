package com.bankaccount.application.rest.commands.dto;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class BankAccountDto {

  private BigDecimal balance;

  private String accountNumber;

  private UserDto user;

  private UUID userId;

}
