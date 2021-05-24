/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Serie;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jcorral
 */
@Stateless
public class SerieFacade extends AbstractFacade<Serie> implements SerieFacadeLocal {

    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SerieFacade() {
        super(Serie.class);
    }

    @Override
    public List<Serie> consultaTodo(int index) {
        String consulta = "FROM Serie p WHERE p.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", index+1);

        List<Serie> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return null;
        } else {
            return resultado;
        }
    }
    
}
