package com.jpdev01.rinha.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record FinancialTransactionResponse(
        BigDecimal valor,
        String tipo,
        String descricao,
        @JsonProperty("realizada_em") OffsetDateTime realizadaEm
) {}
