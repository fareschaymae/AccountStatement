package org.sid.exceptions;

public class AmountNegatifException extends Exception{
	private String message;
	public AmountNegatifException(){
	}
	
	public String getMessage(){
		return this.message = "Le montant ne peut pas etre négatif";
		
	}
	
}
