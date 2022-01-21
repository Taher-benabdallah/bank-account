package fr.societegeneral.bankaccountfr.societegeneral.bankaccount.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import fr.societegeneral.bankaccount.dto.BankAccountDto;
import fr.societegeneral.bankaccount.entity.BankAccount;

public class BankAccountDtoTests {

	private ModelMapper mapper = new ModelMapper();

	private static BankAccount bankAccount;
	private static BankAccountDto bankAccountDto;

	@BeforeAll
	public static void Init() {
		bankAccount = new BankAccount();
		bankAccount.setBalance(100d);
		bankAccount.setCreationDate(LocalDateTime.now());
		bankAccount.setId(1L);
		bankAccountDto = new BankAccountDto();
		bankAccountDto.setBalance(100d);
		bankAccountDto.setCreationDate(LocalDateTime.now());
		bankAccountDto.setId(1L);
	}

	@Test
	public void mapBankAccountEntityEntityToBankAccountDto() {
		BankAccountDto dto = mapper.map(bankAccount, BankAccountDto.class);
		assertEquals(bankAccount.getBalance(), dto.getBalance());
		assertEquals(bankAccount.getId(), dto.getId());
		assertEquals(bankAccount.getCreationDate(), dto.getCreationDate());
	}

	@Test
	public void mapBankAccountDtoToBankAccountEntity() {
		BankAccount entity = mapper.map(bankAccountDto, BankAccount.class);
		assertEquals(bankAccountDto.getBalance(), entity.getBalance());
		assertEquals(bankAccountDto.getId(), entity.getId());
		assertEquals(bankAccountDto.getCreationDate(), entity.getCreationDate());

	}
}
