
package com.selecao.model;

import com.selecao.util.HibernateUtil;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EstadoDAO {
    private Session sessao;
    private Transaction transacao;
    
    public List<Estado> recuperaEstado(){
        List<Estado> listaEstados;
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        String sql = "SELECT * FROM tb_estado";
        SQLQuery consulta = sessao.createSQLQuery(sql);
        consulta.addEntity(Estado.class);
        listaEstados = consulta.list();
        transacao.commit();
        return listaEstados;
    }
}
