package com.ikramBerradi.ebankingbackend.repository;

import com.ikramBerradi.ebankingbackend.entities.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, String> {

}
