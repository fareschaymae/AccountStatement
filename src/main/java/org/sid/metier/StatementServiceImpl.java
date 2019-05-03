package org.sid.metier;

import java.util.Date;
import org.sid.entites.Account;
import org.sid.entites.Statement;
import org.sid.exceptions.AmountNegatifException;
import org.sid.exceptions.AmountGreaterThanBalanceException;
import org.sid.num.type.Type;
import org.sid.repository.AccountRepository;
import org.sid.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatementServiceImpl implements IStatement {
	@Autowired
	StatementRepository statementRepository;
	@Autowired
	AccountRepository accountRepository;
	public boolean deposit(Double amount, Long idAccount, Statement statement) throws AmountNegatifException {
		// TODO Auto-generated method stub
		statement = new Statement();
		Account account= new Account();
		if(amount>0){
			account =accountRepository.findOne(idAccount);
			account.setBalance(account.getBalance() + amount);
			statement.setAccount(account);
			statement.setDate(new Date());
			statement.setAmount(amount);
			statement.setType(Type.DEPOSIT);
			statementRepository.save(statement);
			return true;
		}
		else if(amount<0){ 
			throw new AmountNegatifException();
		} 
		
		return false;
		
	}
	public boolean withdrawal(Double amount, Long idAccount, Statement statement)
			throws AmountNegatifException,
			AmountGreaterThanBalanceException {
		// TODO Auto-generated method stub
		Account c = accountRepository.findOne(idAccount);
		if(amount < c.getBalance() && amount>0){
			statement.setAccount(c);
			statement.setDate(new Date());
			statement.setAmount(amount);
			statement.setType(Type.WITHDRAW);
			statementRepository.save(statement);
			return true;
		}
		else if(amount > c.getBalance()){
			throw new AmountGreaterThanBalanceException();
		}
		else if(amount<0){ 
			throw new AmountNegatifException();
		} 
		return false;
	}
	

}
