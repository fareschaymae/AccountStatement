package org.sid.metier;

import org.sid.entites.Account;
import org.sid.entites.Statement;
import org.sid.exceptions.AmountNegatifException;
import org.sid.exceptions.AmountGreaterThanBalanceException;

public interface IStatement {
	public boolean deposit (Double balance, Long id,Statement statement) throws AmountNegatifException;
	public boolean withdrawal(Double balance, Long id,Statement statement) throws AmountNegatifException, AmountGreaterThanBalanceException;
}
