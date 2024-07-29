package com.jpdev01.rinha.financial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record FinancialTransactionResponseDTO(
        BigDecimal valor,
        String tipo,
        String descricao,
        @JsonProperty("realizada_em") OffsetDateTime realizadaEm
) {}
