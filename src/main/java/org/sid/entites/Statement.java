package org.sid.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.sid.exceptions.AmountNegatifException;
import org.sid.num.type.Type;

@Entity
@Table
public class Statement  {
	
	@Id @GeneratedValue
	private Long idStatement ;
	@NotNull
	private Date date;
	@NotNull
	private double amount;
	
	private Type type;
	
	@OneToOne
	Account account;
	
	public Statement () {
		
		super();
		this.amount = 0.0;
		// TODO Auto-generated constructor stub
	}
	public Statement (Date date, double amount, Type type, Account account) throws AmountNegatifException  {
		if(amount<0){
			throw new AmountNegatifException();
		}
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.account=account;
	}
	public Long getIdStatement() {
		return idStatement;
	}
	public void setIdStatement(Long idStatement) {
		this.idStatement = idStatement;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount){
		this.amount = amount;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
