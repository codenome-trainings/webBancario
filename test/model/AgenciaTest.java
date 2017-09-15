/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiago
 */
public class AgenciaTest {
    
    private Agencia agencia;
    
    @Before
    public void setUp() {
        Integer numero = new Integer(2462);
        Banco banco = Banco.BANCODOBRASIL;
        this.agencia = new Agencia(numero, banco);
    }

    @Test
    public void testToString() {
        String valorEsperado = "Número: " + this.agencia.getNumero() + "\nBanco: " + this.agencia.getBanco();
        String valorAtual = this.agencia.toString();
        assertEquals(valorEsperado, valorAtual);
    }
    

    @Test
    public void testEquals() {
        Agencia agencia2 = new Agencia(this.agencia.getNumero(), this.agencia.getBanco());
        Boolean valorEsperado = true;
        Boolean valorAtual = this.agencia.equals(agencia2);
        assertEquals(valorEsperado, valorAtual);
    }
    
    @Test
    public void testaOMesmoObjeto() {
        Boolean valorEsperado = true;
        Boolean valorAtual = this.agencia.equals(this.agencia);
        assertEquals(valorEsperado, valorAtual);
    }
    
    @Test
    public void testaObjetoNulo() {
        Boolean valorEsperado = false;
        Boolean valorAtual = this.agencia.equals(null);
        assertEquals(valorEsperado, valorAtual);
    }

    @Test
    public void testaSeEAMesmaClasse() {
        Boolean valorEsperado = false;
        Boolean valorAtual = agencia.equals(new Integer(0));
        assertEquals(valorEsperado, valorAtual);
    }
    
    @Test
    public void testaParametroNumeroDaClasseNulo() {
        Agencia agencia2 = new Agencia (null, Banco.ITAU);
        Boolean valorEsperado = false;
        Boolean valorAtual = agencia.equals(agencia2);
        assertEquals(valorEsperado, valorAtual);
    }
    
    @Test
    public void testaParametroBancoDaClasseNulo() {
        Agencia agencia2 = new Agencia (new Integer(1234), null);
        Boolean valorEsperado = false;
        Boolean valorAtual = agencia.equals(agencia2);
        assertEquals(valorEsperado, valorAtual);
    }
    
    @Test
    public void testaNegacaoDosParametros() {
        Agencia agencia2 = new Agencia (new Integer(1234), Banco.BRADESCO);
        Boolean valorEsperado = false;
        Boolean valorAtual = this.agencia.equals(agencia2);
        assertEquals(valorEsperado, valorAtual);
    }
    
    
}
