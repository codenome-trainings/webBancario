/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.Dados;
import dao.PessoaFisicaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.PessoaFisica;

/**
 *
 * @author thiago
 */
@ManagedBean
@SessionScoped
public class guiPessoaFisica {
    
    private PessoaFisica pessoaFisica;
    private List<PessoaFisica> pessoasFisicas;
    private Boolean incluindo;
    
    /**
     * Creates a new instance of guiPessoaFisica
     */
    public guiPessoaFisica() {
    }
    
    public String iniciarPessoaFisica() {
        this.pessoasFisicas = new PessoaFisicaDAO().getList();
        return "listaDeFormularioDePessoaFisica";
    }
    
    public String gravar() {
        Dados dado = new PessoaFisicaDAO();
        
        if (incluindo) {
            try {
                dado.gravar(this.pessoaFisica);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        this.pessoasFisicas = dado.getList();
        
        return "listaDeFormularioDePessoaFisica";
    }
    
    public String novo() {
        this.incluindo = true;
        this.pessoaFisica = new PessoaFisica();
        return "formCadastroPessoaFisica";
    }
    
    public String alterar(PessoaFisica pessoaFisica) {
        this.incluindo = false;
        this.pessoaFisica = pessoaFisica;
        return "formCadastroPessoaFisica";
    }
    
    public String excluir(PessoaFisica pessoafisica) {
        Dados dados = new PessoaFisicaDAO();
        try {
            dados.excluir(this.pessoaFisica);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        this.pessoasFisicas = dados.getList();
        
        return null;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<PessoaFisica> getPessoasFisicas() {
        return pessoasFisicas;
    }

    public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
        this.pessoasFisicas = pessoasFisicas;
    }
    
}
