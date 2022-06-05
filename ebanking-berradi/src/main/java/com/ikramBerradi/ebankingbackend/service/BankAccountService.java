package com.ikramBerradi.ebankingbackend.service;

import java.util.List;

import com.ikramBerradi.ebankingbackend.dto.CustomerDTO;
import com.ikramBerradi.ebankingbackend.dto.SavingBankAccountDTO;
import com.ikramBerradi.ebankingbackend.dto.AccountHistoryDTO;
import com.ikramBerradi.ebankingbackend.dto.AccountOperationDTO;
import com.ikramBerradi.ebankingbackend.dto.BankAccountDTO;
import com.ikramBerradi.ebankingbackend.dto.CurrentBankAccountDTO;
import com.ikramBerradi.ebankingbackend.exception.BalanceNotSufficientException;
import com.ikramBerradi.ebankingbackend.exception.BankAccountNotFoundException;
import com.ikramBerradi.ebankingbackend.exception.CustomerNotFoundException;

public interface BankAccountService {
	
	CustomerDTO saveCustomer(CustomerDTO customerDTO);
	
	CustomerDTO updateCustomer(CustomerDTO customerDTO);
	
	List<CustomerDTO> listCustomers();
	
	void deleteCustomer(Long customerId);
	
	CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;
	
	CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
	
	SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
	
	BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
	
	void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
	
	void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
	
	void transfert(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;
	
	List<BankAccountDTO> listBankAccount();
	
	List<AccountOperationDTO> historique(String accountId);
	
	AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
	
	List<CustomerDTO> searchCustomers(String keyword);
}
