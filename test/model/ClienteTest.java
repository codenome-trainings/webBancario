/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acg
 */
public class ClienteTest {
   private static Cliente cliente1;
   private static Cliente cliente2;
   private static Cliente cliente3;
    
    
    public ClienteTest() {
        
    }
    
    @BeforeClass
   public static void setUpClass() {
        cliente1 = new PessoaFisica("Cliente 1", "12345");
        cliente2 = new PessoaFisica("Cliente 2", "55555");
        cliente3 = new PessoaFisica("Cliente 1", "12345");       
   }


    /**
     * Test of getId method, of class Cliente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Integer expResult = 1;
        Integer result = cliente1.getId();
        assertEquals(expResult, result);

    }


    /**
     * Test of equals method, of class Cliente.
     */
    @Test
    public void testEqualsIgual() {
        System.out.println("equals Igual");
        Cliente c = cliente1;
        boolean expResult = true;
        boolean result = cliente1.equals(c);
        assertEquals(expResult, result);


    }
    @Test
    public void testEqualsDiferente() {
        System.out.println("equals diferente");
        boolean expResult = false;
        boolean result = cliente1.equals(cliente2);
        assertEquals(expResult, result);

    }
    @Test
    public void testEqualsObjetoDiferente() {
        System.out.println("equals diferente");
        boolean expResult = false;
        boolean result = cliente1.equals(new Integer(1));
        assertEquals(expResult, result);

    }

    
}
