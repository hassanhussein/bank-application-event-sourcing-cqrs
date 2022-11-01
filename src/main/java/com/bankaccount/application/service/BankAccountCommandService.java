package com.bankaccount.application.service;

import com.bankaccount.application.commands.CreditBookingAmountCommand;
import com.bankaccount.application.commands.DebitBookingAmountCommand;
import com.bankaccount.application.commands.OpenBankAccountCommand;
import com.bankaccount.application.rest.commands.dto.BookingAmountDto;
import com.bankaccount.application.rest.commands.dto.BankAccountDto;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankAccountCommandService {

  private final BigDecimal initialAmount = new BigDecimal("2000");

  private static final Logger LOG =
      LoggerFactory.getLogger(BankAccountCommandService.class);

  private final CommandGateway commandGateway;

  public BankAccountCommandService(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  public CompletableFuture<BankAccountDto> createAccount(BankAccountDto bankAccount) {

    LOG.info("Open new Bank Account for registered customer");
    OpenBankAccountCommand accountCommand = OpenBankAccountCommand.builder()
        .userId(bankAccount.getUserId())
        .accountId(bankAccount.getAccountId())
        .openingBalance(initialAmount)
        .active(true)
        .build();
    this.commandGateway.sendAndWait(accountCommand);

    return bankAccount;
  }

  public CompletableFuture<String> creditBookingAmountToAccount(UUID accountId,
                                                                BookingAmountDto amountDto) {
    CreditBookingAmountCommand amountCommand = CreditBookingAmountCommand.builder()
        .accountId(accountId)
        .creditAmount(amountDto.getAmount())
        .build();

    return this.commandGateway.send(amountCommand);
  }

  public CompletableFuture<String> debitBookingAmountFromAccount(UUID accountId,
                                                                 BookingAmountDto amountDto) {
    DebitBookingAmountCommand amountCommand = DebitBookingAmountCommand.builder()
        .accountId(accountId)
        .debitAmount(amountDto.getAmount())
        .build();
    return this.commandGateway.send(amountCommand);

  }

}
