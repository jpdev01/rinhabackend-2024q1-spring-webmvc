package com.jpdev01.rinha.financial;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record FinancialResponse(
        FinancialBalanceResponse saldo,
        @JsonProperty("ultimas_transacoes") List<FinancialTransactionResponse> ultimasTransacoes
) { }