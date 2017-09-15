/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.PessoaFisica;

/**
 *
 * @author thiago
 */
public class PessoaFisicaDAO implements Dados {
    
    private static List<PessoaFisica> pessoasJuridicas;

    public PessoaFisicaDAO() {
        this.pessoasJuridicas = new ArrayList<>();
    }
    
    @Override
    public void gravar(Object obj) throws Exception {
        if (obj instanceof PessoaFisica) {
            PessoaFisica pf = (PessoaFisica) obj;
            this.pessoasJuridicas.add(pf);
        }
    }

    @Override
    public void excluir(Object obj) throws Exception {
        if (obj instanceof PessoaFisica) {
            PessoaFisica p = (PessoaFisica) obj;
            this.pessoasJuridicas.remove(p);
        }
    }

    @Override
    public List<PessoaFisica> getList() {
        return this.pessoasJuridicas;
    }
    
    
}
