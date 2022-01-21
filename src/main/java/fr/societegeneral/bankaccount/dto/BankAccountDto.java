package fr.societegeneral.bankaccount.dto;

import java.time.LocalDateTime;

public class BankAccountDto {

	private long id;
	private Double balance;
	private LocalDateTime creationDate;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
