package org.sid;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.sid.entites.Account;
import org.sid.exceptions.AmountNegatifException;
import org.sid.metier.IStatement;
import org.sid.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountManagerApplication.class)
public class AccountTest {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	IStatement statementServiceTmpl;
	@Test
	public void InitialBalanceIsZero(){
		Account account = new Account();
		assertEquals(0.0, account.getBalance(), 0.0);
	}

	@Test
	public void WhenMakingDepositBalanceIncreaseByThatAmount() throws AmountNegatifException{
		List<Account> accounts = accountRepository.findAll();
		double amount = 100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			accountRepository.deposit(c.getId(), (c.getBalance()+amount));
			assertEquals(200.0, accountRepository.findOne(c.getId()).getBalance(), 0.0);			
		}
	}
	
	
	@Test
	public void WhenMakingWithdrawalBalanceDecreaseByThatAmount(){
		List<Account> accounts = accountRepository.findAll();
		double amount = 100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			accountRepository.withdrawal(c.getId(), c.getBalance()-amount);
			assertEquals(0.0, accountRepository.findOne(c.getId()).getBalance(), 0.0);
		}
	}

}
