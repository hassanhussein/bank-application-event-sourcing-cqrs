package com.bankaccount.application.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "bankAccounts")
public class BankAccount extends BaseModel {

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  private String accountNumber;

  @Column(name="balance", columnDefinition="Decimal(10,2) default '100.00'")
  private BigDecimal balance;

}
