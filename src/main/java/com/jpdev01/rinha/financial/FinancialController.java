package com.jpdev01.rinha.financial;

import com.jpdev01.rinha.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}/transacoes")
    public ResponseEntity<String> get() {
        transactionRepository.findAll();
        return ResponseEntity.ok("ok");
    }
}
