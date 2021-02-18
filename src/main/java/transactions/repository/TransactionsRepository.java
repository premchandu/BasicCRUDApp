package transactions.repository;

import org.springframework.data.repository.CrudRepository;

import transactions.model.BankTransaction;

public interface TransactionsRepository extends CrudRepository<BankTransaction, Integer> {
}
