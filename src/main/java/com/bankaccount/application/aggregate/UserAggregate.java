package com.bankaccount.application.aggregate;

import com.bankaccount.application.commands.CreateUserCommand;
import com.bankaccount.application.events.UserCreatedEvent;
import java.util.UUID;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {

  @AggregateIdentifier
  private UUID userId;

  private String firstName;

  private String lastName;

  private String phoneNumber;

  @CommandHandler
  public UserAggregate(CreateUserCommand userCommand) {

    //Perform All the validations here and creatae Events
    //create an event and publish
    UserCreatedEvent userCreatedEvent = new UserCreatedEvent();

    BeanUtils.copyProperties(userCommand, userCreatedEvent);

    AggregateLifecycle.apply(userCreatedEvent);

    //Whenever you  publish the event you need to update the state of the  events

  }

  //whenever there is a change we need to update the state of an event
  @EventSourcingHandler
  public void on(UserCreatedEvent userCreatedEvent) {

    this.firstName = userCreatedEvent.getFirstName();
    this.lastName = userCreatedEvent.getLastName();
    this.userId = userCreatedEvent.getUserId();
    this.phoneNumber = userCreatedEvent.getPhoneNumber();
  }

  public UserAggregate() {

  }

}
