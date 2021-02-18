package transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import transactions.model.BankTransaction;
import transactions.service.TransactionsService;

//creating RestController
@RestController
public class TransactionsRestController {
	@Autowired
	TransactionsService transactionsService;

	//creating a get mapping that retrieves all the transcations from the database 
	@GetMapping("/transactions")
	private List<BankTransaction> getAllTransaction() {
		return transactionsService.getAllTransaction();
	}

	//creating a get mapping that retrieves the detail of a specific transaction
	@GetMapping("/transactions/{id}")
	private BankTransaction getTransaction(@PathVariable("id") int id) {
		return transactionsService.getTransactionById(id);
	}

	//creating a delete mapping that deletes a specific transaction
	@DeleteMapping("/transactions/{id}")
	private void deleteTransaction(@PathVariable("id") int id) {
		transactionsService.delete(id);
	}

	//creating post mapping that post the Transaction detail in the database
	@PostMapping("/transactions")
	private int saveTransaction(@RequestBody BankTransaction transaction) {
		transactionsService.saveOrUpdate(transaction);
		return transaction.getId();
	}
}
