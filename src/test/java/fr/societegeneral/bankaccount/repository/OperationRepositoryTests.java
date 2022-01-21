package fr.societegeneral.bankaccount.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.societegeneral.bankaccount.entity.BankAccount;
import fr.societegeneral.bankaccount.entity.Operation;
import fr.societegeneral.bankaccount.enums.OperationType;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OperationRepositoryTests {
	

	    @Autowired
	    private BankAccountRepository bankAccountRepository;

	    @Autowired
	    private OperationRepository operationRepository;

	    private static BankAccount bankAccount;
	    private static Operation operation;


	    @BeforeEach
	    void init() {
	        bankAccount = new BankAccount(1L);
	        bankAccount.setBalance(990d);
	        operation = new Operation(OperationType.DEPOSIT, 100d);
	    }

	    @Test
	    public void saveAndFindById() {
	       
	        BankAccount savedBankAccount = this.bankAccountRepository.save(bankAccount);
	        assertEquals(savedBankAccount.getBalance(), 990d);

	        operation.setBankAccount(savedBankAccount);
	        Operation savedOperation = this.operationRepository.save(operation);
	        assertEquals(savedOperation.getType(), OperationType.DEPOSIT);
	        assertEquals(savedOperation.getAmount(), 100d);
	    }
}
