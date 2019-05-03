package org.sid.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="account")
public class Account {
	
	@Id @GeneratedValue
	private Long idAccount;
	@NotNull
	private double balance;
	
	
	public Account() {
		super();
		Long id= (long) 0;
		this.idAccount= id;
		this.balance=0.0;
		
	}
	public Account(double balance) {
		super();
		this.balance = balance;
	}
	public Long getId() {
		return idAccount;
	}
	public void setId(Long id) {
		this.idAccount = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
