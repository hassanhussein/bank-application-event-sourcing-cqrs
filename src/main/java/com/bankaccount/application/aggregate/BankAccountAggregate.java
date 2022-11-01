package com.bankaccount.application.aggregate;

import com.bankaccount.application.commands.CreditBookingAmountCommand;
import com.bankaccount.application.commands.DebitBookingAmountCommand;
import com.bankaccount.application.commands.OpenBankAccountCommand;
import com.bankaccount.application.events.CreditedBookingAmountEvent;
import com.bankaccount.application.events.DebitedBookingAmountEvent;
import com.bankaccount.application.events.OpenedAccountEvent;
import com.bankaccount.application.exception.NotEnoughBalanceException;
import com.bankaccount.application.model.Payment;
import java.math.BigDecimal;
import java.util.UUID;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class BankAccountAggregate {

  private UUID userId;

  @AggregateIdentifier
  private UUID accountId;

  private BigDecimal balance;

  private Boolean active;

  @AggregateMember
  private Payment payment;

  @CommandHandler
  public BankAccountAggregate(OpenBankAccountCommand accountCommand) {

    AggregateLifecycle.apply(
        new OpenedAccountEvent(
            accountCommand.getUserId(),
            accountCommand.getAccountId(),
            accountCommand.getOpeningBalance(),
            accountCommand.getActive()
        )
    );
  }

  @EventSourcingHandler
  public void on(OpenedAccountEvent openAccountEvent) {
    this.userId = openAccountEvent.getUserId();
    this.accountId = openAccountEvent.getAccountId();
    this.balance = openAccountEvent.getBalance();
    this.active = openAccountEvent.getActive();

  }

  @CommandHandler
  public void handle(CreditBookingAmountCommand command) {
    AggregateLifecycle.apply(
        new CreditedBookingAmountEvent(
            command.getAccountId(),
            command.getCreditAmount()
        )
    );
  }

  @EventSourcingHandler
  public void on(CreditedBookingAmountEvent event) {

    this.balance = this.balance.add(event.getCreditAmount());
  }

  @CommandHandler
  public void handle(DebitBookingAmountCommand command) {
    AggregateLifecycle.apply(
        new DebitedBookingAmountEvent(
            command.getAccountId(),
            command.getDebitAmount()
        )
    );
  }

  @EventSourcingHandler
  public void on(DebitedBookingAmountEvent event) throws NotEnoughBalanceException {
    if (this.balance.compareTo(event.getDebitAmount()) < 0) {
      throw new NotEnoughBalanceException(event.getAccountId(), event.getDebitAmount());
    }
    this.balance = this.balance.subtract(event.getDebitAmount());
  }

  public BankAccountAggregate() {

  }

}
