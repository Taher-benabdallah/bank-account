package fr.societegeneral.bankaccount.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.societegeneral.bankaccount.dto.BankAccountDto;
import fr.societegeneral.bankaccount.dto.BankAccountRequestBody;
import fr.societegeneral.bankaccount.dto.OpRequestBody;
import fr.societegeneral.bankaccount.dto.OperationDto;
import fr.societegeneral.bankaccount.service.IOperationService;
import fr.societegeneral.bankaccount.swagger.SwaggerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { SwaggerConfig.BANK_ACCOUNT })
@RestController
public class OperationController {

	@Autowired
	private IOperationService operationService;

	@GetMapping(value = "/operations")
	public List<OperationDto> getAllOperations() {
		return operationService.allOperations();
	}

	@GetMapping(value = "/bankAccounts")
	public List<BankAccountDto> getBankAccounts() {
		return operationService.allBankAcounts();
	}

	@PostMapping(value = "/deposit")
	public ResponseEntity<OperationDto> deposit(@RequestBody OpRequestBody opRequestBody) {
		OperationDto newOperation = operationService.deposit(opRequestBody.getAmount());
		if (newOperation == null)
			return ResponseEntity.noContent().build();

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newOperation.getId()).toUri();
		return ResponseEntity.created(location).body(newOperation);
	}

	
	@ApiOperation(value = "Withdrawal Service")
	@PostMapping(value = "/withdraw")
	public ResponseEntity<OperationDto> withdraw(@RequestBody OpRequestBody operation) {
		OperationDto newOperation = operationService.withdraw(operation.getAmount());

		if (newOperation == null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newOperation.getId()).toUri();
		return ResponseEntity.created(location).body(newOperation);
	}

}
