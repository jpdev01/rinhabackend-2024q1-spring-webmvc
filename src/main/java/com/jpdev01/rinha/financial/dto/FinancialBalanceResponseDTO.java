package com.jpdev01.rinha.financial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record FinancialBalanceResponseDTO(
        BigDecimal total,
        @JsonProperty("data_extrato") OffsetDateTime dataExtrato,
        Long limite
) {}
