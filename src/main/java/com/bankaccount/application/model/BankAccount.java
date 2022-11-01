package com.bankaccount.application.model;

import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "bankAccounts")
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount extends BaseModel {

  private UUID userId;

  private UUID accountId;

  @Column(name="balance")
  private BigDecimal balance;

  private Boolean active;

}
