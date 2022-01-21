package fr.societegeneral.bankaccount.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BANK_ACCOUNT")
public class BankAccount {

	@Id
	private long id;
	private Double balance;
	private LocalDateTime creationDate;

	public BankAccount(long id) {
		this.id = id;
		this.creationDate = LocalDateTime.now();
		this.balance = 0d;
	}

	public BankAccount() {
		this.creationDate = LocalDateTime.now();
		this.balance = 0d;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
