/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.PeliculaGenero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cl0ud7
 */
@Local
public interface PeliculaGeneroFacadeLocal {

    void create(PeliculaGenero peliculaGenero);

    void edit(PeliculaGenero peliculaGenero);

    void remove(PeliculaGenero peliculaGenero);

    PeliculaGenero find(Object id);

    List<PeliculaGenero> findAll();

    List<PeliculaGenero> findRange(int[] range);

    int count();
    
}
