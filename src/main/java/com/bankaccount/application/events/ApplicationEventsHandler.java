package com.bankaccount.application.events;

import com.bankaccount.application.model.BankAccount;
import com.bankaccount.application.model.Payment;
import com.bankaccount.application.model.PaymentOption;
import com.bankaccount.application.model.User;
import com.bankaccount.application.repository.BankAccountRepository;
import com.bankaccount.application.repository.PaymentRepository;
import com.bankaccount.application.repository.UserRepository;
import java.time.LocalDate;
import java.util.Date;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("application")
public class ApplicationEventsHandler {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BankAccountRepository bankAccountRepository;

  @Autowired
  private PaymentRepository paymentRepository;

  @EventHandler
  public void on(UserCreatedEvent userCreatedEvent) throws Exception {

    User user = new User();
    BeanUtils.copyProperties(userCreatedEvent, user);
    userRepository.save(user);
    throw new Exception("Exception Occurred");
  }

  @EventHandler
  public void on(OpenedAccountEvent openAccountEvent) throws Exception {

    BankAccount bankAccount = new BankAccount();
    BeanUtils.copyProperties(openAccountEvent, bankAccount);
    bankAccountRepository.save(bankAccount);
    //throw new Exception("Bank Account not opened");
  }

  @EventHandler
  public void on(CreditedBookingAmountEvent creditedBookingAmountEvent) throws Exception {

    Payment payment = new Payment();
    payment.setPaymentMethod(PaymentOption.CREDIT.toString());
    payment.setAmount(creditedBookingAmountEvent.getCreditAmount());
    BankAccount bankAccount = new BankAccount();
    bankAccount.setId(creditedBookingAmountEvent.getAccountId());
    payment.setBankAccount(bankAccount);
    payment.setDateTime(new Date());
    paymentRepository.save(payment);
    //throw new Exception("Bank Account not opened");
  }

  @ExceptionHandler
  public void handle(Exception exception) throws Exception {
    throw exception;
  }

}
