package fr.societegeneral.bankaccount.service;

import java.util.List;

import fr.societegeneral.bankaccount.dto.BankAccountDto;
import fr.societegeneral.bankaccount.dto.OperationDto;

public interface IOperationService {

	OperationDto deposit(Double amount);

	OperationDto withdraw(Double amount);

	List<OperationDto> allOperations();

	BankAccountDto createBankAccount(long accountBankId);
	
	List<BankAccountDto> allBankAcounts();

}
