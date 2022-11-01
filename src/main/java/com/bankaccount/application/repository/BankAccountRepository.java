package com.bankaccount.application.repository;

import com.bankaccount.application.model.BankAccount;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {

}
