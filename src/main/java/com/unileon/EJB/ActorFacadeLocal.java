/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.Actor;
import com.unileon.modelo.Pelicula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author jcorral
 */
@Local
public interface ActorFacadeLocal {

    void create(Actor actor);

    void edit(Actor actor);

    void remove(Actor actor);

    Actor find(Object id);

    List<Actor> findAll();

    List<Actor> findRange(int[] range);
    
    List<Actor> findActorPelis(Pelicula peli);

    int count();
    
}
