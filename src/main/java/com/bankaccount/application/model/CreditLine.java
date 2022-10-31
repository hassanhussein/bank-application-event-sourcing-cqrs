package com.bankaccount.application.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class CreditLine extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "bankAccountId", nullable = false)
  private BankAccount bankAccount;

  private BigDecimal amount;

  private BigDecimal maximumLimitAmount;

}
