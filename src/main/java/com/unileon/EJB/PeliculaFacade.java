/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Pelicula;
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
public class PeliculaFacade extends AbstractFacade<Pelicula> implements PeliculaFacadeLocal {

    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PeliculaFacade() {
        super(Pelicula.class);
    }
    
    @Override
    public List<Pelicula> consultaTodo(int index) {
        String consulta = "FROM Pelicula p WHERE p.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", index+1);

        List<Pelicula> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return null;
        } else {
            return resultado;
        }
    }
    
}
