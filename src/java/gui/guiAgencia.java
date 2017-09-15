/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Agencia;
import model.Banco;

/**
 * 
 * @author thiago
 */
@ManagedBean
@SessionScoped
public class guiAgencia {

    private Agencia agencia;
    
    public guiAgencia() {
    }
    
    public String inciarAgencia() {
        this.agencia = new Agencia();
        return "formCadastroAgencia";
    }
    
    public Banco[] getBancos() {
        return Banco.values();
    }
    
    public String gravar() {
        return "index";
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    
    
}
