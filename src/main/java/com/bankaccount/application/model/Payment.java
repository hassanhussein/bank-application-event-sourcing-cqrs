package com.bankaccount.application.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.AggregateIdentifier;

@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment extends BaseModel {

  @AggregateIdentifier
  private UUID accountId;

  private String paymentMethod;

  private BigDecimal amount;

  private Date dateTime;

  @ManyToOne
  @JoinColumn(name = "bankAccountId", nullable = false)
  private BankAccount bankAccount;

}
