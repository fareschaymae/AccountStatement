package org.sid.tests;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.sid.entites.Account;
import org.sid.entites.Statement;
import org.sid.exceptions.AmountNegatifException;
import org.sid.exceptions.AmountGreaterThanBalanceException;
import org.sid.metier.StatementServiceImpl;
import org.sid.num.type.Type;
import org.sid.repository.AccountRepository;
import org.sid.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OperationTest {
	@Autowired
	StatementRepository statementRepository;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	Account account;
	@Autowired
	Statement statement;
	@Autowired
	StatementServiceImpl statementServiceImpl;
	
	
	@Before
	public void init(){
		account = new Account();
		statement = new Statement();
	}
	
	@Test
	public void testDeposit() throws AmountNegatifException {
		List<Account> accounts = accountRepository.findAll();
		for(Account c: accounts){
			double amount = 100.0;
			statement= new Statement(new Date(), amount, Type.DEPOSIT, c);
			statementRepository.deposit(c.getId(), account.getBalance());
			statementServiceImpl.deposit(amount, c.getId(), statement);
			assertTrue(statementServiceImpl.deposit(amount, c.getId(), statement));
		}
		
		
		
		
		
	}
	@Test
	public void testWithdrawal() throws AmountNegatifException, AmountGreaterThanBalanceException {
		List<Account> accounts = accountRepository.findAll();
		for(Account c: accounts){
			double amount = 100.0;
			statement= new Statement(new Date(), amount, Type.DEPOSIT, c);
			statementRepository.deposit(c.getId(), account.getBalance());
			statementServiceImpl.withdrawal(amount, c.getId(), statement);
			assertTrue(statementServiceImpl.deposit(amount, c.getId(), statement));
		}
		
	}
}
