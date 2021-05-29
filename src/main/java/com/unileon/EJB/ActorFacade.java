/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Actor;
import com.unileon.modelo.Pelicula;
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
public class ActorFacade extends AbstractFacade<Actor> implements ActorFacadeLocal {

    private int id;
    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActorFacade() {
        super(Actor.class);
    }
    
    public  List<Actor> findActoresPeli(Pelicula peli) {
        String consulta = "SELECT pa.actor FROM PeliculaActor pa WHERE pa.pelicula.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", peli.getId());

        List<Actor> resultado = query.getResultList();
        return resultado; 
    }
    
    public  List<Actor> findActoresSerie(Serie serie) {
        String consulta = "SELECT sa.actor FROM SerieActor sa WHERE sa.serie=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", serie);

        List<Actor> resultado = query.getResultList();
        return resultado; 
    }

    @Override
    public Actor actorSeleccionado() {
        String consulta = "FROM Actor a WHERE a.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", id);

        List<Actor> resultado = query.getResultList();
        return resultado.get(0);      }

    @Override
    public void seleccionarActor(int id) {
        this.id=id;
    }
    
}
