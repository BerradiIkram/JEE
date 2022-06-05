package com.ikramBerradi.ebankingbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ikramBerradi.ebankingbackend.entities.CurrentAccount;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, String> {

}
