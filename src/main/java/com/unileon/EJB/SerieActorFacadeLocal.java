/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.SerieActor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cl0ud7
 */
@Local
public interface SerieActorFacadeLocal {

    void create(SerieActor serieActor);

    void edit(SerieActor serieActor);

    void remove(SerieActor serieActor);

    SerieActor find(Object id);

    List<SerieActor> findAll();

    List<SerieActor> findRange(int[] range);

    int count();
    
}
