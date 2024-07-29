package com.jpdev01.rinha.financial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record TransactionRequestDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) Long idCliente,
        BigDecimal valor,
        String tipo,
        String descricao
)
{
    public TransactionRequestDTO withIdCliente(Long idCliente) {
        return new TransactionRequestDTO(idCliente, valor, tipo, descricao);
    }
}