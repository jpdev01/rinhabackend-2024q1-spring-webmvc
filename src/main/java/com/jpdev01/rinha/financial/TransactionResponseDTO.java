package com.jpdev01.rinha.financial;

import java.math.BigDecimal;

public record TransactionResponseDTO(BigDecimal limite, BigDecimal saldo) { }