package fr.societegeneral.bankaccount.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import fr.societegeneral.bankaccount.dto.OperationDto;
import fr.societegeneral.bankaccount.entity.BankAccount;
import fr.societegeneral.bankaccount.entity.Operation;
import fr.societegeneral.bankaccount.repository.BankAccountRepository;
import fr.societegeneral.bankaccount.repository.OperationRepository;
import fr.societegeneral.bankaccount.service.impl.OperationServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationServiceImplTests {

	@Autowired
	private OperationServiceImpl operationService;

	@MockBean
	private OperationRepository operationRepository;

	@MockBean
	private BankAccountRepository bankAccountRepository;

	@BeforeEach
	void init() {

		BankAccount bankAccount = new BankAccount(1L);
		bankAccount.setBalance(1000d);

		Operation operation = new Operation();
		operation.setBankAccount(bankAccount);
		   when(bankAccountRepository.findById(1L))
           .thenReturn(bankAccount);
		when(bankAccountRepository.save(any(BankAccount.class))).thenReturn(bankAccount);

		when(operationRepository.save(any(Operation.class))).thenReturn(operation);

	}

	@Test
	void deposit() {
		OperationDto deposit = operationService.deposit(100d);
		assertNotNull(deposit);
		assertEquals(deposit.getBankAccountBalance(), 1100d);
	}

	@Test
	void withdraw() {
		OperationDto withdraw = operationService.withdraw(100d);
		assertNotNull(withdraw);
		assertEquals(withdraw.getBankAccountBalance(), 900d);
	}
}
