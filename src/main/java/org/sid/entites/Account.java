package org.sid.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.AccessType;

@Entity
@Table

public class Account {
	
	@Id @GeneratedValue
	private Long idAccount;
	@NotNull
	private double balance;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
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
