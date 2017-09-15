/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago
 */
public class ContaCorrenteTest {

    ContaCorrente contaCorrente;

    @Before
    public void setUp() throws Exception {
        Integer numero = new Integer(12345);
        Agencia agencia = new Agencia(new Integer(1234), Banco.ITAU);
        Cliente cliente = new PessoaFisica("12312312333", "Thiago Cunha");
        
        contaCorrente = new ContaCorrente(numero, agencia, cliente);
        
        LocalDateTime data = LocalDateTime.now();
        BigDecimal valor = new BigDecimal(300.0);
        TipoMovimento tipoMovimento = TipoMovimento.credito;
        String descricao = "Deposito bancario";
        this.contaCorrente.lancarMovimento(data, valor, tipoMovimento, descricao);

    }

    @Test
    public void testGetSaldo() throws Exception {
        BigDecimal valorEsperado = new BigDecimal(300);
        BigDecimal valorAtual = contaCorrente.getSaldo();
        assertEquals(valorEsperado, valorAtual);
    }

    @Test
    public void testLancarMovimentoCredito() throws Exception {
        
        LocalDateTime data = LocalDateTime.now();
        BigDecimal valor = new BigDecimal(300.0);
        TipoMovimento tipoMovimento = TipoMovimento.credito;
        String descricao = "Deposito bancario";
        contaCorrente.lancarMovimento(data, valor, tipoMovimento, descricao);
        
        BigDecimal valorEsperado = new BigDecimal(600);
        BigDecimal valorAtual = contaCorrente.getSaldo();
        
        assertEquals(valorEsperado, valorAtual);
    }

    @Test
    public void testLancarMovimentoDebitoComSaldo() throws Exception {

        LocalDateTime data = LocalDateTime.now();
        BigDecimal valor = new BigDecimal(100.0);
        TipoMovimento tipoMovimento = TipoMovimento.debito;
        String descricao = "Deposito bancario";
        contaCorrente.lancarMovimento(data, valor, tipoMovimento, descricao);
        
        BigDecimal valorEsperado = new BigDecimal(200);
        BigDecimal valorAtual = contaCorrente.getSaldo();

        assertEquals(valorEsperado, valorAtual);
    }

    @Test(expected = Exception.class)
    public void testLancarMovimentoDebitoComSaldoInsuficiente() throws Exception {

        LocalDateTime data = LocalDateTime.now();
        BigDecimal valor = new BigDecimal(1000.0);
        TipoMovimento tipoMovimento = TipoMovimento.debito;
        String descricao = "Deposito bancario";
        contaCorrente.lancarMovimento(data, valor, tipoMovimento, descricao);
        
        BigDecimal valorEsperado = new BigDecimal(0);
        BigDecimal valorAtual = contaCorrente.getSaldo();

        assertEquals(valorEsperado, valorAtual);
    }

}
