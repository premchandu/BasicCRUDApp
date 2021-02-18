package transactions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import transactions.model.BankTransaction;
import transactions.repository.TransactionsRepository;

//service layer for CRUD
@Service
public class TransactionsService {
	//Have to take lock on this shared repository for all thread requests.
	@Autowired
	TransactionsRepository transactionsRepository;

	public List<BankTransaction> getAllTransaction() {
		List<BankTransaction> transcations = new ArrayList<BankTransaction>();
		synchronized (transactionsRepository) {
			transactionsRepository.findAll().forEach(eachTranscation -> transcations.add(eachTranscation));
		}
		return transcations;
	}

	public synchronized BankTransaction getTransactionById(int id) {
		return transactionsRepository.findById(id).get();
	}

	public synchronized void saveOrUpdate(BankTransaction transaction) {
		transactionsRepository.save(transaction);
	}

	public synchronized void delete(int id) {
		transactionsRepository.deleteById(id);
	}
}