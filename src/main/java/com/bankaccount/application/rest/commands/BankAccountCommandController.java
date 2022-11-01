package com.bankaccount.application.rest.commands;

import static com.bankaccount.application.rest.commands.BankAccountCommandController.RESOURCE_PATH;

import com.bankaccount.application.rest.commands.dto.BookingAmountDto;
import com.bankaccount.application.rest.commands.dto.BankAccountDto;
import com.bankaccount.application.service.BankAccountCommandService;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(RESOURCE_PATH)
public class BankAccountCommandController extends BaseController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountCommandController.class);
  public static final String RESOURCE_PATH = API_PATH + "/bankAccounts";

  @Autowired
  private BankAccountCommandService service;

  @PostMapping
  public BankAccountDto returnValues(@RequestBody BankAccountDto bankAccountDto){

    LOGGER.info("validate empty object");
    Validate.notNull(bankAccountDto);
    service.createAccount(bankAccountDto);
    return bankAccountDto;

  }

  @PutMapping(value = "/credit/{accountId}")
  public CompletableFuture<String> creditBookingAmountToAccount(@PathVariable(value = "accountId") UUID accountId,
                                                        @RequestBody BookingAmountDto creditAmount) {
    return this.service.creditBookingAmountToAccount(accountId, creditAmount);
  }

  @PutMapping(value = "/debit/{accountId}")
  public CompletableFuture<String> debitBookingAmountFromAccount(@PathVariable(value = "accountId") UUID accountId,
                                                         @RequestBody BookingAmountDto moneyDebitDTO) {
    return this.service.debitBookingAmountFromAccount(accountId, moneyDebitDTO);
  }

}
