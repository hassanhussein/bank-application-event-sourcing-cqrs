package com.bankaccount.application.events;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenedAccountEvent {

  private UUID userId;

  private UUID accountId;

  private BigDecimal balance;

  private Boolean active;

}
