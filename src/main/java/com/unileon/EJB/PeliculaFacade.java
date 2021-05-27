/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Pelicula;
import java.sql.ResultSet;
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
        query.setParameter("param1", index);

        List<Pelicula> resultado = query.getResultList();
        if(resultado.isEmpty()){
            return null;
        } else {
            return resultado;
        }
    }

//    @Override
//    public int maximoId() {
//        //String consulta = "SELECT p FROM Pelicula p WHERE MAX(Id)";
//         String consulta = "SELECT MAX(p.id) FROM Pelicula p";
//        Query query = em.createQuery(consulta);
//
//        
//        int resultado = query.getFirstResult();
//        //int max = resultado.get(0).getId();
//        return resultado;       
//        
//    }
    
}
