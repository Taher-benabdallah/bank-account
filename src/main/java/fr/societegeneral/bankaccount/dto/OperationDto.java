package fr.societegeneral.bankaccount.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.societegeneral.bankaccount.enums.OperationType;

public class OperationDto {

	private int id;

	private OperationType type;

	private Double amount;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime date;

	@JsonProperty("balance")
	private Double bankAccountBalance;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getBankAccountBalance() {
		return bankAccountBalance;
	}

	public void setBankAccountBalance(Double bankAccountBalance) {
		this.bankAccountBalance = bankAccountBalance;
	}

}
