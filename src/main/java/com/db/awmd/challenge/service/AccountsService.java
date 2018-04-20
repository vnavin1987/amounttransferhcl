package com.db.awmd.challenge.service;

import com.db.awmd.challenge.domain.Account;
import com.db.awmd.challenge.domain.TransferRequest;
import com.db.awmd.challenge.repository.AccountsRepository;
import lombok.Getter;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsService {

  @Getter
  private final AccountsRepository accountsRepository;

  @Autowired
  public AccountsService(AccountsRepository accountsRepository) {
    this.accountsRepository = accountsRepository;
  }

  public void createAccount(Account account) {
    this.accountsRepository.createAccount(account);
  }

  public Account getAccount(String accountId) {
    return this.accountsRepository.getAccount(accountId);
  }
  
  public Boolean transferAmount(TransferRequest transferRequest) {

	  String fromAccountId = transferRequest.getFromAccountId();
	  String toAccountId = transferRequest.getToAccountId();
	  BigDecimal amount = transferRequest.getAmount();
	  
	  if(!isValidateAcconts(fromAccountId, toAccountId)) {
		  //throw InvalidAccountId();
	  }
	  
	  return true;
	  }
  private Boolean isValidateAcconts(String fromAccountId, String toAccountId) {
	 
	  if(accountsRepository.getAccount(fromAccountId)==null || accountsRepository.getAccount(toAccountId)==null ) {
		  return false;
	  }
	  
	  return true;
  }
}
