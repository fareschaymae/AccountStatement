package org.sid.metier;

import org.sid.entites.Statement;
import org.sid.exceptions.AmountNegatifException;
import org.sid.exceptions.AmountGreaterThanBalanceException;

public interface IStatement {
	public boolean deposit (Double amount, Long idAccount,Statement statement) throws AmountNegatifException;
	public boolean withdrawal(Double amount, Long idAccount,Statement statement) throws AmountNegatifException, AmountGreaterThanBalanceException;
}
