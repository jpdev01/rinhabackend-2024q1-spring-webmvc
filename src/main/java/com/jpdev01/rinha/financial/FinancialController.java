package com.jpdev01.rinha.financial;

import com.jpdev01.rinha.financial.dto.*;
import com.jpdev01.rinha.repository.TransactionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class FinancialController {

    private final TransactionRepository transactionRepository;

    public FinancialController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @PostMapping("/{id}/transacoes")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@PathVariable("id") Long idCliente, @RequestBody TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setIdCliente(idCliente);
        transaction.setValor(transactionRequestDTO.valor());
        transaction.setTipo(transactionRequestDTO.tipo());
        transaction.setDescricao(transactionRequestDTO.descricao());

        transaction = transactionRepository.save(transaction).block();

        TransactionResponseDTO responseDTO = new TransactionResponseDTO(
                transaction.getValor(),
                transaction.getValor()
        );
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{id}/extrato")
    public ResponseEntity<FinancialResponseDTO> extrato(@PathVariable("id") Long idCliente) {
        Flux<Transaction> transactionFlux = transactionRepository.findAllByIdCliente(idCliente);

        BigDecimal total = getTotal(transactionFlux);

        FinancialBalanceResponseDTO balance = new FinancialBalanceResponseDTO(
                total,
                OffsetDateTime.now(),
                1000L
        );

        List<FinancialTransactionResponseDTO> financialTransactionResponses = transactionFlux
                .map(transaction -> new FinancialTransactionResponseDTO(
                        transaction.getValor(),
                        transaction.getTipo(),
                        transaction.getDescricao(),
                        OffsetDateTime.now()
                ))
                .collectList()
                .block();

        FinancialResponseDTO response = new FinancialResponseDTO(balance, financialTransactionResponses);
        return ResponseEntity.ok(response);
    }

    private BigDecimal getTotal(Flux<Transaction> transactions) {
        return transactions
                .map(Transaction::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .block();
    }
}
