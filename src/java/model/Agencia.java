/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thiago Cunha
 * @version 1.0
 * 
 */
public class Agencia {

    private Integer numero;
    private Banco banco;
    
    public Agencia() {    
    }
    
    public Agencia(Integer numero, Banco banco) {
        this.numero = numero;
        this.banco = banco;
    }

    public Integer getNumero() {
        return numero;
    }

    public Banco getBanco() {
        return banco;
    }

    @Override
    public String toString() {
        return "Número: " + this.numero + "\nBanco: " + this.banco;
    }
    
    
    /** Método que trato as comparações da classe.
     * Na primeira comparação trato os objetos.
     * A segunda comparação, vejo se o objeto está nulo.
     * A Terceira comparação, trato se as classes são iguais.
     * Caso todos os tratamentos passarem, ai sim é comparado o número da agência e o banco que foi passado como referência.
     * @author Thiago Cunha
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Agencia)) return false;
        
        Agencia other = (Agencia) obj;
        
        if ((this.numero == null) || (this.banco == null)) {
            if ((other.getNumero() == null) || (other.getBanco() == null)) {
                return false;
            }
        } else if (!this.numero.equals(other.getNumero()) && !this.banco.equals(other.getBanco())) {
            return false;
        }
        
        return true;
    }

}
