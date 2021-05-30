/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Comentario;
import com.unileon.modelo.Pelicula;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cl0ud7
 */
@Stateless
public class ComentarioFacade extends AbstractFacade<Comentario> implements ComentarioFacadeLocal {

    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Comentario> consultaTodo(Pelicula pelicula) {
        String consulta = "FROM Comentario c WHERE c.pelicula=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", pelicula);

        List<Comentario> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return null;
        } else {
            return resultado;
        }
    }

    public ComentarioFacade() {
        super(Comentario.class);
    }
    
}
