package com.ikramBerradi.ebankingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikramBerradi.ebankingbackend.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
