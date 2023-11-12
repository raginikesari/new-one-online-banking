package xyz.team1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xyz.team1.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    
}
