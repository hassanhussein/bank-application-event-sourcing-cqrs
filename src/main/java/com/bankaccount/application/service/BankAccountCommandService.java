package com.bankaccount.application.service;

import com.bankaccount.application.rest.commands.dto.BankAccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BankAccountCommandService {

  private final static Logger LOG =
      LoggerFactory.getLogger(BankAccountCommandService.class);

  public BankAccountDto createAccount(BankAccountDto bankAccount) throws Exception {

    if (bankAccount == null) {
      LOG.info("Bank account ");
      throw new Exception("Object is empty");
    }
    return bankAccount;

  }
}
