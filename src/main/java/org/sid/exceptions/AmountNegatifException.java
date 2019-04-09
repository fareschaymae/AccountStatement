package org.sid.exceptions;

public class AmountNegatifException extends Exception{
	private String message;
	public AmountNegatifException(){
		System.out.println("Le montant ne peut pas etre négatif");
	}
	
	public String getMessage(){
		return this.message = "Le montant ne peut pas etre négatif";
		
	}
	
}
