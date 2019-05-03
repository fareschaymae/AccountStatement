package org.sid.exceptions;

public class AmountGreaterThanBalanceException extends Exception{
	private String message;
	public AmountGreaterThanBalanceException(){
	}
	
	public String getMessage(){
		return this.message = "Le montant à retirer doit etre inféreiur ou égale au solde";
		
	}
}
