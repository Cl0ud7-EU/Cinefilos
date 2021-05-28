/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.PeliculaActor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cl0ud7
 */
@Local
public interface PeliculaActorFacadeLocal {

    void create(PeliculaActor peliculaActor);

    void edit(PeliculaActor peliculaActor);

    void remove(PeliculaActor peliculaActor);

    PeliculaActor find(Object id);

    List<PeliculaActor> findAll();

    List<PeliculaActor> findRange(int[] range);

    int count();
    
}
