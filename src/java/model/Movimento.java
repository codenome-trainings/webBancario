/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 * @author thiago
 */
public class Movimento {
    
    private String descricao;
    private LocalDateTime dataMovimento;
    private BigDecimal valor;
    private TipoMovimento tipoMovimento;
    
    public Movimento(String descricao, LocalDateTime dataMovimento, BigDecimal valor, TipoMovimento tipoMovimento) {
        this.descricao = descricao;
        this.dataMovimento = dataMovimento;
        this.valor = valor;
        this.tipoMovimento = tipoMovimento;
    }

    public LocalDateTime getDataMovimento() {
        return dataMovimento;
    }

    public BigDecimal getValor() {
        return valor;
    }
    
}
