package com.ikramBerradi.ebankingbackend;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.ikramBerradi.ebankingbackend.entities.AccountOperation;
import com.ikramBerradi.ebankingbackend.entities.CurrentAccount;
import com.ikramBerradi.ebankingbackend.entities.Customer;
import com.ikramBerradi.ebankingbackend.entities.SavingAccount;
import com.ikramBerradi.ebankingbackend.enums.AccountStatus;
import com.ikramBerradi.ebankingbackend.enums.OperationType;
import com.ikramBerradi.ebankingbackend.repository.AccountOperationRepository;
import com.ikramBerradi.ebankingbackend.repository.BankAccountRepository;
import com.ikramBerradi.ebankingbackend.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ikramBerradi.ebankingbackend.dto.BankAccountDTO;
import com.ikramBerradi.ebankingbackend.dto.CurrentBankAccountDTO;
import com.ikramBerradi.ebankingbackend.dto.CustomerDTO;
import com.ikramBerradi.ebankingbackend.dto.SavingBankAccountDTO;
import com.ikramBerradi.ebankingbackend.exception.CustomerNotFoundException;
import com.ikramBerradi.ebankingbackend.service.BankAccountService;

@SpringBootApplication
public class EbankingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankingBackendApplication.class, args);
	}

	//@Bean
	CommandLineRunner start(BankAccountService bankAccountService) {
		return args -> {
			Stream.of("ikram", "sara", "salma").forEach(name -> {
				CustomerDTO customer = new CustomerDTO();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				bankAccountService.saveCustomer(customer);
			});
			bankAccountService.listCustomers().forEach(customer -> {
				try {
					bankAccountService.saveCurrentBankAccount(Math.random()*9000, 9000, customer.getId());
					bankAccountService.saveSavingBankAccount(Math.random()*120000, 5.5, customer.getId());
					
					
				} catch (CustomerNotFoundException e) {
					e.printStackTrace();
				} 
			});
			List<BankAccountDTO> bankAccounts = bankAccountService.listBankAccount();
			for(BankAccountDTO bankAccount: bankAccounts) {
				for(int i=0; i<10; i++) {
					String accountId;
					if(bankAccount instanceof SavingBankAccountDTO) {
						accountId = ((SavingBankAccountDTO) bankAccount).getId();
					}
					else {
						accountId = ((CurrentBankAccountDTO) bankAccount).getId();
					}
					bankAccountService.credit(accountId, 10000+Math.random()*120000, "Credit");
					bankAccountService.debit(accountId, 1000+Math.random()*9000, "Debit");
				}
			}
		};
	}


	
	
@Bean
	CommandLineRunner start(CustomerRepository customerRepository,
							BankAccountRepository bankAccountRepository,
							AccountOperationRepository accountOperationRepository) {
	
		return args -> {
			
			Stream.of("ikram", "omayma", "sara").forEach(name -> {
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(name+"@gmail.com");
				customerRepository.save(customer);
			});
			
			customerRepository.findAll().forEach(cust -> {
				CurrentAccount currentAccount = new CurrentAccount();
				currentAccount.setId(UUID.randomUUID().toString());
				currentAccount.setBalance(Math.random()*90000);
				currentAccount.setCreatedAt(new Date());
				currentAccount.setStatus(AccountStatus.CREATED);
				currentAccount.setCustomer(cust);
				currentAccount.setOverDraft(9000);
				bankAccountRepository.save(currentAccount);
			});
			
			customerRepository.findAll().forEach(cust -> {
				SavingAccount savingAccount = new SavingAccount();
				savingAccount.setId(UUID.randomUUID().toString());
				savingAccount.setBalance(Math.random()*90000);
				savingAccount.setCreatedAt(new Date());
				savingAccount.setStatus(AccountStatus.CREATED);
				savingAccount.setCustomer(cust);
				savingAccount.setInterestRate(5.5);
				bankAccountRepository.save(savingAccount);
			});
			
			bankAccountRepository.findAll().forEach(acc -> {
				for(int i = 0; i<10; i++) {
					AccountOperation accountOperation = new AccountOperation();
					accountOperation.setOperationDate(new Date());
					accountOperation.setAmount(Math.random()*12000);
					accountOperation.setType(Math.random()>0.5? OperationType.DEBIT: OperationType.CREDIT);
					accountOperation.setBankAccount(acc);
					accountOperationRepository.save(accountOperation);
				}
			});
			
		};
	}
}
