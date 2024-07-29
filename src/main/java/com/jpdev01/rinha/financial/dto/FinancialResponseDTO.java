package com.jpdev01.rinha.financial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FinancialResponseDTO(
        FinancialBalanceResponseDTO saldo,
        @JsonProperty("ultimas_transacoes") List<FinancialTransactionResponseDTO> ultimasTransacoes
) { }