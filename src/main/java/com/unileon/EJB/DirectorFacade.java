/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Director;
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
public class DirectorFacade extends AbstractFacade<Director> implements DirectorFacadeLocal {

    private int id;
    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DirectorFacade() {
        super(Director.class);
    }

    @Override
    public Director directorSeleccionado() {
        String consulta = "FROM Director d WHERE d.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", id);

        List<Director> resultado = query.getResultList();
        return resultado.get(0);    
    }

    @Override
    public void seleccionarDirector(int id) {
        this.id=id;
    }
    
}
