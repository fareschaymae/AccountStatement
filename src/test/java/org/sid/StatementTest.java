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
public class StatementTest {
	@Autowired
	AccountRepository accountRepository;

	@Autowired
	IStatement statementServiceTmpl;
	
	
	@Test
	public void InitialBalanceIsZero(){
		Statement statement = new Statement();
		assertEquals(0.0, statement.getAmount(), 0.0);
	}
	
	@Test
	public void WhenMakingDepositBalanceIncreaseByThatAmount() throws AmountNegatifException{
		List<Account> accounts = accountRepository.findAll();
		Statement statement = new Statement();
		double amount = 100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			accountRepository.deposit(c.getId(), (c.getBalance()+amount));
			statementServiceTmpl.deposit(amount, c.getId(), statement);
			assertEquals("", true, statementServiceTmpl.deposit(amount, c.getId(), statement));
		}
	}
	
	@Test
	public void WhenMakingWithrawalBalanceDecreaseByThatAmount() throws AmountNegatifException, AmountGreaterThanBalanceException{
		List<Account> accounts = accountRepository.findAll();
		Statement statement = new Statement();
		double amount = -100.0;
		for(Account c: accounts){
			c.setBalance(100.0);
			accountRepository.deposit(c.getId(), (c.getBalance()+amount));
			statementServiceTmpl.withdrawal(amount, c.getId(), statement);
			assertEquals("", true, statementServiceTmpl.withdrawal(amount, c.getId(), statement));
		}
	}
}
