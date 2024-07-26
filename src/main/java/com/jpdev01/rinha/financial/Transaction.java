package com.jpdev01.rinha.financial;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("transacao")
public class Transaction {

    @Id
    private Long id;
    @Column("id_cliente")
    private Long idCliente;
    @Column("valor")
    private BigDecimal valor;
    @Column("tipo")
    private String tipo;
    @Column("descricao")
    private String descricao;

    public Long getId() {
        return id;
    }

    public Transaction setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public Transaction setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Transaction setValor(BigDecimal valor) {
        this.valor = valor;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public Transaction setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Transaction setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }
}

//@Table("transactions")
//public record Transaction(
//        @Id
//        Long id,
//        Long idCliente,
//        Long valor,
//        String tipo,
//        String descricao
//) {
//}