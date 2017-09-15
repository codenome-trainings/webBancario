/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.AgenciaDAO;
import dao.Dados;
import java.util.ArrayList;
import java.util.List;
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
    private List<Agencia> agencias;
    private Boolean incluindo;

    public guiAgencia() {
    }
    
    public String iniciarAgencia() {
        this.agencias = new AgenciaDAO().getList();
        return "listaDeAgencias";
    }
    
    public String gravar() {
        Dados dado = new AgenciaDAO();
        if (incluindo) {
            try {
                dado.gravar(this.agencia);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        this.agencias = dado.getList();
        
        return "listaDeAgencias";
    }
    
    public String novo() {
        this.incluindo = new Boolean(true);
        this.agencia = new Agencia();
        return "formCadastroAgencia";
    }
    
    public String alterar(Agencia agencia) {
        this.incluindo = new Boolean(false);
        this.agencia = agencia;
        return "formaCadastroAgencia";
    }
    
    public String excluir(Agencia agencia) {
        Dados dado = new AgenciaDAO();
        try {
            dado.excluir(agencia);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.agencias = dado.getList();
        return null;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }
}
