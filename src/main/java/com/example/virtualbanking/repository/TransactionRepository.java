package com.example.virtualbanking.repository;

import com.example.virtualbanking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {


}
