
package com.selecao.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="tb_estado")
public class Estado implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private int id_estado;
    private String nome_estado;
    private String uf_estado;

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }

    public String getUf_estado() {
        return uf_estado;
    }

    public void setUf_estado(String uf_estado) {
        this.uf_estado = uf_estado;
    }
    
}
