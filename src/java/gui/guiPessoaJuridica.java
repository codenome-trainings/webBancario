/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.Dados;
import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.PessoaFisica;
import model.PessoaJuridica;

/**
 *
 * @author thiago
 */
@ManagedBean
@SessionScoped
public class guiPessoaJuridica {
    
    private PessoaJuridica pessoaJuridica;
    private List<PessoaJuridica> pessoasJuridicas;
    private Boolean incluindo;
    
    /**
     * Creates a new instance of guiPessoaJuridica
     */
    public guiPessoaJuridica() {
    }
    
    public String iniciarPessoaJuridica() {
        this.pessoasJuridicas = new PessoaJuridicaDAO().getList();
        return "listaDeFormularioDePessoaJuridica";
    }
    
    public String gravar() {
        Dados dado = new PessoaFisicaDAO();
        
        if(incluindo) {
            try {
                dado.gravar(this.pessoaJuridica);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        this.pessoasJuridicas = dado.getList();
        
        return "listaDeFormularioDePessoaJuridica";
    }
    
    public String novo() {
        this.incluindo = true;
        this.pessoaJuridica = new PessoaJuridica();
        return "formCadastroPessoaJuridica";
    }
    
    public String alterar(PessoaFisica pessoaFisica) {
        this.incluindo = false;
        this.pessoaJuridica = pessoaJuridica;
        return "formCadastroPessoaJuridica";
    }
    
    public String excluir(PessoaJuridica pessoaJuridica) {
        Dados dados = new PessoaFisicaDAO();
        try {
            dados.excluir(pessoaJuridica);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        this.pessoasJuridicas = dados.getList();
        return null;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }
    
}
