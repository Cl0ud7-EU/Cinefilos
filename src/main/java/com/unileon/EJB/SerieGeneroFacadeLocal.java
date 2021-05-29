/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unileon.EJB;

import com.unileon.modelo.SerieGenero;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cl0ud7
 */
@Local
public interface SerieGeneroFacadeLocal {

    void create(SerieGenero serieGenero);

    void edit(SerieGenero serieGenero);

    void remove(SerieGenero serieGenero);

    SerieGenero find(Object id);

    List<SerieGenero> findAll();

    List<SerieGenero> findRange(int[] range);

    int count();
    
}
