/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Agencia;

/**
 *
 * @author aluno
 */
public class AgenciaDAO implements Dados {
    
    private static List<Agencia> agencias;

    public AgenciaDAO() {
        this.agencias = new ArrayList<>();
    }
    
    @Override
    public void gravar(Object obj) throws Exception {
        Agencia agencia = (Agencia) obj;
        this.agencias.add(agencia);
    }

    @Override
    public void excluir(Object obj) throws Exception {
        Agencia agencia = (Agencia) obj;
        this.agencias.remove(agencia);
    }

    @Override
    public List<Agencia> getList() {
        return this.agencias;
    }
    
}
