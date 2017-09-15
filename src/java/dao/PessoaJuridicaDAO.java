/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.PessoaJuridica;

/**
 *
 * @author thiago
 */
public class PessoaJuridicaDAO implements Dados{
    
    private static List<PessoaJuridica> pessoasJuridicas;

    public PessoaJuridicaDAO() {
        this.pessoasJuridicas = new ArrayList<>();
    }
    
    @Override
    public void gravar(Object obj) throws Exception {
        if (obj instanceof PessoaJuridica) {
            PessoaJuridica pj = (PessoaJuridica) obj;
            this.pessoasJuridicas.add(pj);
        }
    }

    @Override
    public void excluir(Object obj) throws Exception {
        if (obj instanceof PessoaJuridica) {
            PessoaJuridica pj = (PessoaJuridica) obj;
            this.pessoasJuridicas.remove(pj);
        }
    }

    @Override
    public List<PessoaJuridica> getList() {
        return this.pessoasJuridicas;
    }
    
}
