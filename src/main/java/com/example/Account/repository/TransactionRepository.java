package com.example.Account.repository;

import com.example.Account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<Transaction> findByTransactionId(String transactionId);
}
