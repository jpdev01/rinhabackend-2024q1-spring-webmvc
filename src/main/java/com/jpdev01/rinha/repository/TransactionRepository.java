package com.jpdev01.rinha.repository;

import com.jpdev01.rinha.financial.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {

}
