package org.sid;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.sid.entites.Account;
import org.sid.entites.Statement;
import org.sid.exceptions.AmountGreaterThanBalanceException;
import org.sid.exceptions.AmountNegatifException;
import org.sid.metier.IStatement;
import org.sid.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountManagerApplication.class)
public class ExceptionsTest {
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	IStatement statementServiceTmpl;
	
	@Test(expected=AmountNegatifException.class)
	public void ValidateDepositWithAmountNegatifException() throws AmountNegatifException{
		List<Account> accounts = accountRepository.findAll();
		Statement statement = new Statement();
		double amount = -100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			statementServiceTmpl.deposit(amount, c.getId(), statement);
		}
	}
	
	@Test(expected=AmountNegatifException.class)
	public void ValidateWithrawaltWithAmountNegatifException() throws AmountNegatifException, AmountGreaterThanBalanceException{
		List<Account> accounts = accountRepository.findAll();
		Statement statement = new Statement();
		double amount = -100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			statementServiceTmpl.withdrawal(amount, c.getId(), statement);
		}
	}
	
	@Test(expected=AmountGreaterThanBalanceException.class)
	public void ValidateWithrawalWithAmountGreaterThanBalanceException() throws AmountGreaterThanBalanceException, AmountNegatifException{
		List<Account> accounts = accountRepository.findAll();
		Statement statement = new Statement();
		double amount = 100000.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			statementServiceTmpl.withdrawal(amount, c.getId(), statement);
		}
	}

}
