/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 *
 * @author thiago
 */
public class ContaCorrente {

    private Integer numero;
    private Agencia agencia;
    private Cliente cliente;
    private List<Movimento> movimentos;

    public ContaCorrente(Integer numero, Agencia agencia, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.cliente = cliente;
        this.movimentos = new ArrayList<>();
    }

    /**
     * Método que retorna a soma das movimentações.
     *
     * @return saldo
     */
    public BigDecimal getSaldo() {
        BigDecimal saldo = new BigDecimal(0);
        for (Movimento movimento : movimentos) {
            saldo = saldo.add(movimento.getValor());
        }
        return saldo;
    }

    public List<Movimento> getLancamentos() {
        return this.movimentos;
    }

    public Integer getNumero() {
        return numero;
    }

    /**
     * Para lançar o movimento, o método precisa comparar o tipo de movimento
     * (Debito ou crédito). Ao passar o valor como referência, passamos
     * BigDecimal.plus() para creditar a conta e BigDecimal.negate() para
     * debitar a conta. Caso a conta é debitada, outro filtro é ocorrido, e
     * passa a verificar se a saldo suficiente para realizar a transação.
     *
     * @param data Armazena a isntancia do tempo local.
     * @param valor Valor a ser sacado ou depositado
     * @param tipoMovimento Verifica o tipo de movimentação
     * @param descricao Descrição do saque
     * @throws Exception Caso não há saldo suficiente, uma exception é gerada
     * para bloquear a transação.
     */
    public void lancarMovimento(LocalDateTime data, BigDecimal valor, TipoMovimento tipoMovimento, String descricao) throws Exception {
        switch (tipoMovimento) {
            case credito:
                this.movimentos.add(new Movimento(descricao, data, valor.plus(), tipoMovimento));
                break;
            case debito:
                if (this.getSaldo().compareTo(valor) >= 0) {
                    this.movimentos.add(new Movimento(descricao, data, valor.negate(), tipoMovimento));
                } else {
                    throw new Exception("Saldo insuficiente!");
                }
                break;
            default:
                throw new Exception("Tipo de movimentação inválida!");
        }
    }

    @Override
    public String toString() {
        return "Número: " + this.numero;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContaCorrente other = (ContaCorrente) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    
    
    

}
