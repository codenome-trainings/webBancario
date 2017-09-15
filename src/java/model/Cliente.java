/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author acg
 */
public abstract class Cliente {
    private static Integer prxId = 1;
    private Integer id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(String nome) {
        this.nome = nome;
        this.id = prxId;
        prxId++;
    }

    public Cliente() {
        this.id = prxId;
        prxId++;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }


    @Override
    public boolean equals(Object obj) {
        try {
            return ((Cliente) obj).getId().equals(this.id);
        } catch (Exception e) {
            return false;
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
    
    
    
}
