package com.jpdev01.rinha.financial.dto;

import java.math.BigDecimal;

public record TransactionResponseDTO(BigDecimal limite, BigDecimal saldo) { }