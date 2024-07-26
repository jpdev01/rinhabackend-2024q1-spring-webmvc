package com.jpdev01.rinha.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record FinancialBalanceResponse(
        BigDecimal total,
        @JsonProperty("data_extrato") OffsetDateTime dataExtrato,
        Long limite
) {}
