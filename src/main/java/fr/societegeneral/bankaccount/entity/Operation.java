package fr.societegeneral.bankaccount.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import fr.societegeneral.bankaccount.enums.OperationType;

@Entity
@Table(name="OPERATION")
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Operation type is mandatory")
	@Enumerated(EnumType.STRING)
	private OperationType type;

	@NotNull(message = "Amount is mandatory")
	private Double amount;

	private LocalDateTime date;

	@NotNull(message = "Bank account is mandatory")
	@ManyToOne
	private BankAccount bankAccount;

	public Operation() {
		this.date = LocalDateTime.now();
	}

	public Operation(OperationType type, Double amount) {
		this.type = type;
		this.amount = amount;
		this.date = LocalDateTime.now();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		return "Operation{" + "id=" + id + ", type=" + type + ", amount=" + amount + ", actualBalance="
				+ date.format(formatter) + "}";
	}

}
