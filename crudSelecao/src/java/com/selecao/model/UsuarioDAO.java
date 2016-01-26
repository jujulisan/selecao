
package com.selecao.model;

import com.selecao.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuarioDAO {
    private Session sessao;
    private Transaction transacao;
    private List<Object[]> listaUsuarios;
    
    public boolean salvar(Usuario usuario){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(usuario);
            transacao.commit();
            return true;
        }catch(HibernateException erro){
            return false;
        }
    }
    
    public List<Object[]> listaTodosUsuarios(){
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        String sql = "SELECT id_usuario, nome_usuario, email_usuario, tel_usuario, end_usuario, uf_estado "
                + "FROM tb_user JOIN tb_estado ON tb_user.id_estado=tb_estado.id_estado";
        SQLQuery consulta = sessao.createSQLQuery(sql);
        listaUsuarios = consulta.list();
        transacao.commit();
        return listaUsuarios;
    }
    
    public boolean excluir(int id_usuario){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String sql = "DELETE FROM tb_user WHERE id_usuario = :id_usu";
            SQLQuery consulta = sessao.createSQLQuery(sql);
            consulta.setParameter("id_usu", id_usuario);
            consulta.executeUpdate();
            transacao.commit();
            return true;
        }catch(HibernateException erro){
            return false;
        }
    }
    
    public boolean atualizar(Usuario usuario){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(usuario);
            transacao.commit();
            return true;
        }catch(HibernateException erro){
            return false;
        }
    }
    
    public Usuario recuperaUsuario(int id_usuario){
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String sql = "SELECT * FROM tb_user WHERE id_usuario = :id_usu";
            SQLQuery consulta = sessao.createSQLQuery(sql);
            consulta.setParameter("id_usu", id_usuario);
            consulta.addEntity(Usuario.class);
            Usuario usuario = (Usuario) consulta.uniqueResult();
            transacao.commit();
            return usuario;
        }catch(HibernateException erro){
            return null;
        }
    }
}
