/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Genero;
import com.unileon.modelo.Pelicula;
import com.unileon.modelo.Serie;
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
public class GeneroFacade extends AbstractFacade<Genero> implements GeneroFacadeLocal {

    @PersistenceContext(unitName = "cinefilosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public  List<Genero> findGenerosPeli(Pelicula peli) {
        String consulta = "SELECT pg.genero FROM PeliculaGenero pg WHERE pg.pelicula.id=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", peli.getId());

        List<Genero> resultado = query.getResultList();
        return resultado; 
    }
    
    public  List<Genero> findGenerosSerie(Serie serie) {
        
        String consulta = "SELECT sg.genero FROM SerieGenero sg WHERE sg.serie=:param1";
        Query query = em.createQuery(consulta);
        query.setParameter("param1", serie);

        List<Genero> resultado = query.getResultList();
        return resultado; 
    }

    public GeneroFacade() {
        super(Genero.class);
    }
    
}
