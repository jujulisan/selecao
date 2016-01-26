
package com.selecao.controller;

import com.selecao.model.Usuario;
import com.selecao.model.UsuarioDAO;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioBean {

    Usuario usuario = new Usuario();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    private List<Object[]> listaUsuarios;
    
    public UsuarioBean() {
    }
    
    public String salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException{
        if(usuarioDAO.salvar(usuario))
            return "lista_usuario";
        else
            return "erro_salvar";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public List<Object[]> getListaUsuarios() {
        listaUsuarios = usuarioDAO.listaTodosUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Object[]> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String excluir (int id_usuario){
        if(usuarioDAO.excluir(id_usuario))
            return "lista_usuario";
        else
            return "erro_excluir";
    }
    
    public String atualizar(){
        if(usuarioDAO.atualizar(usuario))
            return "lista_usuario";
        else
            return "erro_atualizar";
    }
    
    public void carregarUsuario(int id_usuario){
        usuario = usuarioDAO.recuperaUsuario(id_usuario);
    }
}
