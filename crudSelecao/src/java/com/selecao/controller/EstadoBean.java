
package com.selecao.controller;

import com.selecao.model.Estado;
import com.selecao.model.EstadoDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class EstadoBean {

    EstadoDAO estadoDAO = new EstadoDAO();
    List<Estado> listaEstado;
    
    public EstadoBean() {
    }

    public EstadoDAO getEstadoDAO() {
        return estadoDAO;
    }

    public void setEstadoDAO(EstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public List<Estado> getListaEstado() {
        listaEstado = estadoDAO.recuperaEstado();
        return listaEstado;
    }

    public void setListaEstado(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }
    
}
