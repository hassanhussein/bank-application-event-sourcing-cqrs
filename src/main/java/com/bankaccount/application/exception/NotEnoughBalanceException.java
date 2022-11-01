package com.bankaccount.application.exception;

import java.math.BigDecimal;
import java.util.UUID;

public class NotEnoughBalanceException extends Throwable {

  public NotEnoughBalanceException(UUID accountId, BigDecimal debitAmount) {
    super("Insufficient Balance: Cannot debit " + debitAmount +
        " from account number [" + accountId.toString() + "]");
  }

}
