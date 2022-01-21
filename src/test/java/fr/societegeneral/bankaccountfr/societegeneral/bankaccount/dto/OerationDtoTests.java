package fr.societegeneral.bankaccountfr.societegeneral.bankaccount.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import fr.societegeneral.bankaccount.dto.OperationDto;
import fr.societegeneral.bankaccount.entity.BankAccount;
import fr.societegeneral.bankaccount.entity.Operation;
import fr.societegeneral.bankaccount.enums.OperationType;

public class OerationDtoTests {
	private ModelMapper mapper = new ModelMapper();
	private static Operation operation;
	private static OperationDto operationDto;

	@BeforeAll
	public static void Init() {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBalance(1000d);
		operation = new Operation();
		operation.setBankAccount(bankAccount);
		operation.setType(OperationType.DEPOSIT);
		operation.setAmount(100d);
		operationDto = new OperationDto();
		operationDto.setBankAccountBalance(500d);
		operationDto.setType(OperationType.WITHDRAWAL);
		operationDto.setAmount(-100d);
		operationDto.setDate(LocalDateTime.now());
	}

	@Test
	public void mapOperationEntityToOperationDto() {
		OperationDto dto = mapper.map(operation, OperationDto.class);
		assertEquals(operation.getType(), dto.getType());
		assertEquals(operation.getAmount(), dto.getAmount());
		assertEquals(operation.getBankAccount().getBalance(), dto.getBankAccountBalance());
	}

	@Test
	public void mapOperationDtoToOperationEntity() {
		Operation op = mapper.map(operationDto, Operation.class);
		assertEquals(op.getType(), operationDto.getType());
		assertEquals(op.getAmount(), operationDto.getAmount());
		assertEquals(op.getBankAccount().getBalance(), operationDto.getBankAccountBalance());
	}

}
