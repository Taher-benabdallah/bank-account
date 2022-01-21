package fr.societegeneral.bankaccount.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import fr.societegeneral.bankaccount.dto.BankAccountDto;
import fr.societegeneral.bankaccount.dto.OperationDto;
import fr.societegeneral.bankaccount.entity.BankAccount;
import fr.societegeneral.bankaccount.entity.Operation;
import fr.societegeneral.bankaccount.enums.OperationType;
import fr.societegeneral.bankaccount.repository.BankAccountRepository;
import fr.societegeneral.bankaccount.repository.OperationRepository;
import fr.societegeneral.bankaccount.service.IOperationService;

@Service
public class OperationServiceImpl implements IOperationService {

	@Autowired
	OperationRepository operationRepository;
	@Autowired
	BankAccountRepository bankAccountRepository;
	// map entity to data transfert object (dto)
	@Autowired
	ModelMapper mapper;

	@Override
	public OperationDto deposit(Double amount) {

		if (amount > 0) {
			BankAccount bankAccount = (BankAccount) bankAccountRepository.findById(1L);
			Operation operation = new Operation(OperationType.DEPOSIT, amount);
			bankAccount.setBalance(bankAccount.getBalance() + amount);
			operation.setBankAccount(bankAccount);
			bankAccountRepository.save(bankAccount);
			return mapper.map(operationRepository.save(operation), OperationDto.class);
		}
		return null;
	}

	@Override
	public OperationDto withdraw(Double amount) {
		if (amount > 0) {
			BankAccount bankAccount = (BankAccount) bankAccountRepository.findById(1L);
			Operation operation = new Operation(OperationType.WITHDRAWAL, amount);
			bankAccount.setBalance(bankAccount.getBalance() - amount);
			operation.setBankAccount(bankAccount);
			bankAccountRepository.save(bankAccount);
			return mapper.map(operationRepository.save(operation), OperationDto.class);
		}
		return null;
	}

	@Override
	public List<OperationDto> allOperations() {

		List<Operation> ops = operationRepository.findAll();
		return ops.stream().map(operation -> mapper.map(operation, OperationDto.class)).collect(Collectors.toList());

	}

	@Override
	public BankAccountDto createBankAccount(long accountBankId) {

		BankAccount bankAccount = bankAccount = new BankAccount(accountBankId);
		return mapper.map(bankAccountRepository.save(bankAccount), BankAccountDto.class);
	}

	@Override
	public List<BankAccountDto> allBankAcounts() {

		List<BankAccount> bankAccounts = bankAccountRepository.findAll();
		return bankAccounts.stream().map(bankAccount -> mapper.map(bankAccount, BankAccountDto.class))
				.collect(Collectors.toList());
	}

}
