package com.bankaccount.application.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "payments")
public class Payment extends BaseModel {

  private String paymentMethod;

  private BigDecimal amount;

  private Date dateTime;

  @ManyToOne
  @JoinColumn(name = "bankAccountId", nullable = false)
  private BankAccount bankAccount;

}
